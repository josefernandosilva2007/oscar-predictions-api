package com.fears.oscar_predictions_api.service;


import com.fears.oscar_predictions_api.dto.CategoryDTO;
import com.fears.oscar_predictions_api.entity.Category;
import com.fears.oscar_predictions_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAllCategories(){
        List<Category> all = categoryRepository.findAll();
        return all.stream().map(CategoryDTO::new).toList();
    }
}
