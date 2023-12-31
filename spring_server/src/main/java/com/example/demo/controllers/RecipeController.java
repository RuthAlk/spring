package com.example.demo.controllers;

import java.util.List;

import com.example.demo.datamodel.Recipe;
import com.example.demo.datamodel.RecipeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/recipes")
@RestController
public class RecipeController {
    ObjectMapper mapper = new ObjectMapper();

    private final RecipeRepository repository;

    @Autowired
    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = {"","/"})
    public List<Recipe> findAll() {
            return repository.findAll();
    }

    /**
     * TODO: Check if there really isn't a more default way of adding all these basic methods?
     */
    @PostMapping("/create")
    public ResponseEntity<Recipe> createItem(@RequestBody Recipe recipe) {
        System.out.println("Got recipe: " + safeToString(recipe));
        return ResponseEntity.ok(repository.save(recipe));
    }

    private String safeToString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return String.valueOf(o);
        }
    }

    @GetMapping("/{recipeId}")
    public Recipe getByID(@PathVariable Long recipeId) {
        return this.repository.findById(recipeId).get();
    }

    @DeleteMapping("/{recipeId}")
    public void deleteByID(@PathVariable Long recipeId) {
        this.repository.deleteById(recipeId);
    }

}


    

