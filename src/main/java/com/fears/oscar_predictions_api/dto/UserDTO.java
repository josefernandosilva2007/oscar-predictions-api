package com.fears.oscar_predictions_api.dto;

import com.fears.oscar_predictions_api.entity.Nomination;
import com.fears.oscar_predictions_api.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDTO {

    private String username;
    private List<NominationDTO> nominations = new ArrayList<>();

    public UserDTO(User entity) {
        username = entity.getUsername();
        nominations = entity.getNominations().stream().map(NominationDTO::new).toList();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(username, userDTO.username) && Objects.equals(nominations, userDTO.nominations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, nominations);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<NominationDTO> getNominations() {
        return nominations;
    }

    public void setNominations(List<NominationDTO> nominations) {
        this.nominations = nominations;
    }
}
