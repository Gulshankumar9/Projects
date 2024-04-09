package com.springdocopenapi.greetings;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingsService implements GreetingsRepository {

    private static List<Greetings> greetings = new ArrayList<>();

    public GreetingsService() {
        greetings.add(new Greetings(1, "John", "Doe", "Hello World"));
        greetings.add(new Greetings(2, "Emerson", "Wilks", "Hello World"));
        greetings.add(new Greetings(3, "Wade", "Savage", "Hello World"));
        greetings.add(new Greetings(4, "Star", "Lott", "Hello World"));
        greetings.add(new Greetings(5, "Claudia", "James", "Hello World"));


    }


    @Override
    public List<Greetings> getAll() {
        return greetings;
    }

    public Greetings getById(Integer id) {
        return new Greetings(id, "John", "Doe", "Hello World");
    }

    @Override
    public Greetings save(Greetings newGreetings) {
        return null;
    }

    @Override
    public Greetings update(Greetings newGreetings) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }


}