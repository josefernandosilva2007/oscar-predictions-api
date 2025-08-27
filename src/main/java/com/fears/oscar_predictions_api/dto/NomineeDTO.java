package com.fears.oscar_predictions_api.dto;

import com.fears.oscar_predictions_api.entity.Nominee;

import java.util.Objects;

public class NomineeDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private Boolean isWinner;
    private String imgUrl;

    public NomineeDTO(){
    }

    public NomineeDTO(Nominee entity) {
        id = entity.getId();
        name = entity.getName();
        categoryId = entity.getCategory().getId();
        imgUrl = entity.getImgUrl();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NomineeDTO that = (NomineeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(categoryId, that.categoryId) && Objects.equals(isWinner, that.isWinner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryId, isWinner);
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }
}
