package com.example.demo.datamodel;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "ingredients_list")
    @Column(name = "ingredient")
    private List<String> ingredients;
    
    @ElementCollection
    @CollectionTable(name = "steps_list")
    @Column(name = "step")
    private List<String> steps;

    /**
     * @return the ingredients
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * @return the steps
     */
    public List<String> getSteps() {
        return steps;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    
}
