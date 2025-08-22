package com.fears.oscar_predictions_api.service;

import com.fears.oscar_predictions_api.dto.NominationDTO;
import com.fears.oscar_predictions_api.entity.Nomination;
import com.fears.oscar_predictions_api.repository.NominationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NominationService {
    @Autowired
    private NominationRepository nominationRepository;

    public List<NominationDTO> findAll(){
        List<Nomination> all = nominationRepository.findAll();
        return all.stream().map(NominationDTO::new).toList();
    }
}
