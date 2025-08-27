package com.fears.oscar_predictions_api.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_nominee")
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String imgUrl;
    private Boolean is_winner;

    public Nominee() {
    }

    public Nominee(Long id, String name, Category category, Boolean is_winner, String imgUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.is_winner = is_winner;
        this.imgUrl = imgUrl;
    }


    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Nominee nominee = (Nominee) o;
        return Objects.equals(id, nominee.id) && Objects.equals(name, nominee.name) && Objects.equals(category, nominee.category) && Objects.equals(is_winner, nominee.is_winner);
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
