package com.fears.oscar_predictions_api.dto;

import com.fears.oscar_predictions_api.entity.Category;
import com.fears.oscar_predictions_api.entity.Nominee;

import java.util.Objects;

public class NomineeDTO {
    private Long id;
    private String name;
    private Category category;
    private Boolean is_winner;

    public NomineeDTO(){
    }

    public NomineeDTO(Nominee entity) {
        id = entity.getId();
        name = entity.getName();
        category = entity.getCategory();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NomineeDTO that = (NomineeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(category, that.category) && Objects.equals(is_winner, that.is_winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, is_winner);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getIs_winner() {
        return is_winner;
    }

    public void setIs_winner(Boolean is_winner) {
        this.is_winner = is_winner;
    }
}
