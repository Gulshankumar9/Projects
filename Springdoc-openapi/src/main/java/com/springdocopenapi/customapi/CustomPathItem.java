package com.springdocopenapi.customapi;

import com.springdocopenapi.greetings.Greetings;
import com.springdocopenapi.greetings.GreetingsRepository;
import io.swagger.v3.oas.models.PathItem;

import java.util.List;

public class CustomPathItem extends PathItem {

    private GreetingsRepository greetingsRepository;

    public CustomPathItem(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    public List<Greetings> executeGet() {
        return greetingsRepository.getAll();
    }
}