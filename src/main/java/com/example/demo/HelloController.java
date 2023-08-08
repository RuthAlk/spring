package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    private NameSupplier nameSupplier;

    @Autowired
    public HelloController(NameSupplier nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
    
    @GetMapping("/")
    public String getIndex(@RequestParam(name="greeting", required=false, defaultValue="Hello") String greeting, Model model) {
        model.addAttribute("greeting", greeting);
        model.addAttribute("name", nameSupplier.getName());
        return "greeting"; // points to the template used, I guess
    }
}
