package com.example.comedogenicingredients.strategy;

import com.example.comedogenicingredients.model.Ingredient;

public interface ComedogenicStrategy {
    boolean isComedogenic(Ingredient ingredient);
}
