package com.example.demo.controllers;

import com.example.demo.services.NameSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private NameSupplier nameSupplier;

    @Autowired
    public HelloController(NameSupplier nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
    
    @GetMapping("/greeting")
    public String getIndex(@RequestParam(name="greeting", required=false, defaultValue="Hello") String greeting) {
        return greeting + " " + nameSupplier.getName(); // points to the template used, I guess
    }
}
