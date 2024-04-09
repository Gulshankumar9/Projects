package com.example.customswaggerui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CustomSwaggerUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomSwaggerUiApplication.class, args);
    }

}