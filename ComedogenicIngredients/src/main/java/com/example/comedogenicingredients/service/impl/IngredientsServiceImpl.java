package com.example.comedogenicingredients.service.impl;

import com.example.comedogenicingredients.model.Ingredient;
import com.example.comedogenicingredients.repository.IngredientRepository;
import com.example.comedogenicingredients.service.IngredientService;
import com.example.comedogenicingredients.strategy.ComedogenicStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    private ComedogenicStrategy strategy;

    public IngredientsServiceImpl(final IngredientRepository ingredientRepository, ComedogenicStrategy strategy) {
        this.ingredientRepository = ingredientRepository;
        this.strategy = strategy;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Ingredient> getAllIngredients() {return ingredientRepository.findAll();}

    public List<String> getCloggingIngredients(List<String> ingredientNames) {
        List<String> cloggingIngredients = new ArrayList<>();
        for (String name : ingredientNames) {
            Optional<Ingredient> ingredient = ingredientRepository.findByName(name);
            if (ingredient.isPresent() && strategy.isComedogenic(ingredient.get())) {
                cloggingIngredients.add(name);
            }
        }
        return cloggingIngredients;
    }
}
