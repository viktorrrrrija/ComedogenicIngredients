package com.example.comedogenicingredients.service;

import com.example.comedogenicingredients.model.Ingredient;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAllIngredients();

    List<String> getCloggingIngredients(List<String> ingredientNames);
}
