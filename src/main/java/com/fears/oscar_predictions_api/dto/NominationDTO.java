package com.fears.oscar_predictions_api.dto;

import com.fears.oscar_predictions_api.entity.Nomination;

import java.util.Objects;

public class NominationDTO {
    private Long id;
    private Long userId;
    private Long nomineeId;
    private String nomineeName;
    private String categoryName;


    public NominationDTO(){}

    public NominationDTO(Nomination entity){
        id = entity.getId();
        userId = entity.getUser().getId();
        nomineeId = entity.getNominee().getId();
        nomineeName = entity.getNominee().getName();
        categoryName = entity.getNominee().getCategory().getName();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NominationDTO that = (NominationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(nomineeId, that.nomineeId) && Objects.equals(nomineeName, that.nomineeName) && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, nomineeId, nomineeName, categoryName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(Long nomineeId) {
        this.nomineeId = nomineeId;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
