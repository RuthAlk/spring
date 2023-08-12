package com.example.demo.datamodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoDataInit implements CommandLineRunner {

    private final RecipeRepository demoDataRepository;

    @Autowired
    public DemoDataInit(RecipeRepository demoDataRepository) {
        this.demoDataRepository = demoDataRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating demo data");
        // Insert your demo data here
        Recipe data1 = new Recipe(/* Initialize data properties */);
        Recipe data2 = new Recipe(/* Initialize data properties */);
        data1.setName("Creme brulee");
        data2.setName("Frietjes");

        demoDataRepository.save(data1);
        demoDataRepository.save(data2);

        // You can add more demo data or perform other initialization tasks
    }
}
