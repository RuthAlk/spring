package com.example.demo.controllers;

import java.util.List;

import com.example.demo.datamodel.Recipe;
import com.example.demo.datamodel.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository repository;

    @Autowired
    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = {"","/"})
    public String findAll(Model model) {
        model.addAttribute("recipes", repository.findAll());
        return "recipe_list";
    }

    @GetMapping("/{recipeId}")
    public Recipe getUser(@PathVariable Long recipeId) {
        return this.repository.findById(recipeId).get();
    }

    @GetMapping("/{userId}/ingredients")
    public List<String> getUserCustomers(@PathVariable Long recipeId) {
        return this.repository.findById(recipeId).map(Recipe::getIngredients).get();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        this.repository.deleteById(userId);
    }

}


    
