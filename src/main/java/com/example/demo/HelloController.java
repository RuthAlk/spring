package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private NameSupplier nameSupplier;

    @Autowired
    public HelloController(NameSupplier nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
    
    @GetMapping("/")
    public String getIndex() {
        return "Hello " + nameSupplier.getName();
    }
}
