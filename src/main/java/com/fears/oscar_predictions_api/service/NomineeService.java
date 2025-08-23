package com.fears.oscar_predictions_api.service;

import com.fears.oscar_predictions_api.dto.NomineeDTO;
import com.fears.oscar_predictions_api.entity.Category;
import com.fears.oscar_predictions_api.entity.Nominee;
import com.fears.oscar_predictions_api.exception.EntityNotFoundException;
import com.fears.oscar_predictions_api.repository.CategoryRepository;
import com.fears.oscar_predictions_api.repository.NomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomineeService {
    @Autowired
    private NomineeRepository nomineeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<NomineeDTO> findAll() {
        List<Nominee> all = nomineeRepository.findAll();
        return all.stream().map(NomineeDTO::new).toList();
    }

    public NomineeDTO saveNominee(NomineeDTO entity) {
        Optional<Category> byId = categoryRepository.findById(entity.getCategoryId());
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Category not found");
        }
        var n = new Nominee(entity.getId(), entity.getName(), byId.get(), entity.getIsWinner());
        Nominee save = nomineeRepository.save(n);
        return new NomineeDTO(save);
    }
}
