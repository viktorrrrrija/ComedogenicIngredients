package com.example.comedogenicingredients.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    private int id;
    private String name;
    @Column(name = "comedogenicRating")
    private Integer comedogenicRating;
    @Column(name = "irritancy")
    private Integer irritancy;

    public Ingredient(int id, String name, int comedogenicRating, int irritancy) {
        super();
        this.id = id;
        this.name = name;
        this.comedogenicRating = comedogenicRating;
        this.irritancy = irritancy;
    }

    public Ingredient() {

    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getComedogenicRating() {
        return comedogenicRating;
    }

    public Integer getIrritancy() {
        return irritancy;
    }
}