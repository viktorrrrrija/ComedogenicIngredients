package com.example.comedogenicingredients.controller;


import com.example.comedogenicingredients.model.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping(value = "/ingredients")
public interface IngredientController {

    @GetMapping
    List<Ingredient> getIngredients();
}
