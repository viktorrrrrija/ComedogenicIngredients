package com.example.comedogenicingredients.controller.impl;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.comedogenicingredients.controller.IngredientController;
import com.example.comedogenicingredients.model.Ingredient;
import com.example.comedogenicingredients.service.IngredientService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class IngredientControllerImpl implements IngredientController {

    private final IngredientService ingredientService;

    public IngredientControllerImpl(final IngredientService ingredientService) {this.ingredientService = ingredientService;}

    @Override
    public List<Ingredient> getIngredients() {return ingredientService.getAllIngredients();}


    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @PostMapping("/index")
    public String checkIngredients(@RequestParam("ingredients") String ingredients, Model model) {

        List<String> ingredientNames = Arrays.stream(ingredients.split("[,\\n]"))
                .map(String::trim)
                .collect(Collectors.toList());

        System.out.println(ingredientNames);

        List<String> clogging = ingredientService.getCloggingIngredients(ingredientNames);

        System.out.println(clogging);

        if (!clogging.isEmpty()) {
            model.addAttribute("resultMessage", "Unfortunately, there are some pore-clogging ingredients in your product.");
            model.addAttribute("resultClass", "alert-danger");
        } else {
            model.addAttribute("resultMessage", "Congratulations! Your product has no pore-clogging ingredients.");
            model.addAttribute("resultClass", "alert-success");
        }

        model.addAttribute("ingredients",  String.join(", ", ingredientNames));
        model.addAttribute("retrievedList", ingredientNames);
        model.addAttribute("clogging",  clogging);


        return "index";
    }

    @GetMapping("/ingredients")
    public String ingredients(Model model) {

        model.addAttribute("listIngredient", ingredientService.getAllIngredients());
        return "ingredients";
    }
}
