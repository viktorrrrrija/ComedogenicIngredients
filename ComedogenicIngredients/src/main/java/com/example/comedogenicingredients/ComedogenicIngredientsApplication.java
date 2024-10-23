package com.example.comedogenicingredients;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static javafx.application.Application.launch;

@SpringBootApplication
public class ComedogenicIngredientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComedogenicIngredientsApplication.class, args);
    }

}
