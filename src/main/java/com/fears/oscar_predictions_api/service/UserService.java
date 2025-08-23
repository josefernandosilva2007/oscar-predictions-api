package com.fears.oscar_predictions_api.service;


import com.fears.oscar_predictions_api.dto.UserDTO;
import com.fears.oscar_predictions_api.entity.Nomination;
import com.fears.oscar_predictions_api.entity.User;
import com.fears.oscar_predictions_api.exception.EntityNotFoundException;
import com.fears.oscar_predictions_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveNewUser(User entity){
        User save = userRepository.save(entity);
        return new UserDTO(save);
    }

    public List<UserDTO> findAll(){
        List<User> all = userRepository.findAllWithNomination();
        return all.stream().map(UserDTO::new).toList();
    }

    public UserDTO findByID(Long id){
        Optional<User> byId = userRepository.findByIdWithNomination(id);
        return byId.map(UserDTO::new).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

}
