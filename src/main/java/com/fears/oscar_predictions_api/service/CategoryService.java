package com.fears.oscar_predictions_api.service;


import com.fears.oscar_predictions_api.dto.CategoryDTO;
import com.fears.oscar_predictions_api.entity.Category;
import com.fears.oscar_predictions_api.exception.EntityNotFoundException;
import com.fears.oscar_predictions_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO saveNewCategory(CategoryDTO entity){
        Category category = new Category(entity.getId(), entity.getName());
        Category save = categoryRepository.save(category);
        return new CategoryDTO(save);
    }


    public List<CategoryDTO> findAllCategories(){
        List<Category> all = categoryRepository.findAll();
        return all.stream().map(CategoryDTO::new).toList();
    }

    public CategoryDTO findCategoryById(Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.map(CategoryDTO::new).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }
}
