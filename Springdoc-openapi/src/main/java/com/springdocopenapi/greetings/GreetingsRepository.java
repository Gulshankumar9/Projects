package com.springdocopenapi.greetings;

import java.util.List;

public interface GreetingsRepository {

    List<Greetings> getAll();

    Greetings getById(Integer id);

    Greetings save(Greetings newGreetings);

    Greetings update(Greetings newGreetings);

    void delete(Integer id);


}