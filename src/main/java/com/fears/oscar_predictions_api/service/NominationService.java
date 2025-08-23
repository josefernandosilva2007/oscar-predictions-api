package com.fears.oscar_predictions_api.service;

import com.fears.oscar_predictions_api.dto.NominationDTO;
import com.fears.oscar_predictions_api.entity.Category;
import com.fears.oscar_predictions_api.entity.Nomination;
import com.fears.oscar_predictions_api.entity.Nominee;
import com.fears.oscar_predictions_api.entity.User;
import com.fears.oscar_predictions_api.exception.EntityNotFoundException;
import com.fears.oscar_predictions_api.repository.CategoryRepository;
import com.fears.oscar_predictions_api.repository.NominationRepository;
import com.fears.oscar_predictions_api.repository.NomineeRepository;
import com.fears.oscar_predictions_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NominationService {
    @Autowired
    private NominationRepository nominationRepository;

    @Autowired
    private NomineeRepository nomineeRepository;

    @Autowired
    private UserRepository userRepository;


    public List<NominationDTO> findAll(){
        List<Nomination> all = nominationRepository.findAll();
        return all.stream().map(NominationDTO::new).toList();
    }

    public NominationDTO saveNomination(NominationDTO entity){
        Nominee nomineeByID = nomineeRepository.findById(entity.getNomineeId()).orElseThrow(() -> new EntityNotFoundException("Nominee not found"));
        User userById = userRepository.findById(entity.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Nomination n = new Nomination(entity.getId(), userById, nomineeByID);
        return new NominationDTO(nominationRepository.save(n));
    }
}
