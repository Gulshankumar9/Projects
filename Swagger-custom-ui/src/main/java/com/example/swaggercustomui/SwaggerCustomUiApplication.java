package com.example.swaggercustomui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SwaggerCustomUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerCustomUiApplication.class, args);
    }

}