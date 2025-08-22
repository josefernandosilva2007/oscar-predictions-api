package com.fears.oscar_predictions_api.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_nomination")
public class Nomination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "nominee_id")
    private Nominee nominee;

    public Nomination(){}

    public Nomination(Long id, User user, Nominee nominee) {
        this.id = id;
        this.user = user;
        this.nominee = nominee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Nomination that = (Nomination) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(nominee, that.nominee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, nominee);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }
}
