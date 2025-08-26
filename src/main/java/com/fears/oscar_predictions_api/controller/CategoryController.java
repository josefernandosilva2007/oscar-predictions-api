package com.fears.oscar_predictions_api.controller;


import com.fears.oscar_predictions_api.dto.CategoryDTO;
import com.fears.oscar_predictions_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllCategories());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> saveNewCategory(@RequestBody CategoryDTO entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveNewCategory(entity));
    }



}
