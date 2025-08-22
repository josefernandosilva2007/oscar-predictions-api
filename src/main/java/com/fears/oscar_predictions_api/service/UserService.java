package com.fears.oscar_predictions_api.service;


import com.fears.oscar_predictions_api.dto.UserDTO;
import com.fears.oscar_predictions_api.entity.User;
import com.fears.oscar_predictions_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> all = userRepository.findAll();
        return all.stream().map(UserDTO::new).toList();
    }

}
