package com.example.comedogenicingredients.strategy;

import com.example.comedogenicingredients.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class HighComedogenicStrategy implements ComedogenicStrategy {

    @Override
    public boolean isComedogenic(Ingredient ingredient) {

            return ingredient.getComedogenicRating() > 3;

    }
}
