package com.fears.oscar_predictions_api.dto;


import com.fears.oscar_predictions_api.entity.Category;

import java.util.Objects;

public class CategoryDTO{
    private Long id;
    private String name;

    public CategoryDTO(){
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO that = (CategoryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
