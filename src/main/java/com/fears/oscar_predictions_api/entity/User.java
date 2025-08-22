package com.fears.oscar_predictions_api.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    public User(Long id, String username, Nomination nomination) {
        this.id = id;
        this.username = username;
        this.nomination = nomination;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(nomination, user.nomination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, nomination);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Nomination getNomination() {
        return nomination;
    }

    public void setNomination(Nomination nomination) {
        this.nomination = nomination;
    }
}
