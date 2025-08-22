package com.fears.oscar_predictions_api.service;

import com.fears.oscar_predictions_api.dto.NomineeDTO;
import com.fears.oscar_predictions_api.entity.Nominee;
import com.fears.oscar_predictions_api.repository.NomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomineeService {
    @Autowired
    private NomineeRepository nomineeRepository;

    public List<NomineeDTO> findAll(){
        List<Nominee> all = nomineeRepository.findAll();
        return all.stream().map(NomineeDTO::new).toList();
    }
}
