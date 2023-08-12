package com.example.demo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class FunnyNameSupplier implements NameSupplier{
    private List<String> names = Arrays.asList("Pietje Bell", "Hans Worst");
    private Random r = new Random();

    @Override
    public String getName() {
        return names.get(r.nextInt(names.size()));
    }
    
}
