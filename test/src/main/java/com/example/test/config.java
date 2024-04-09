package com.example.test;


import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public OpenApiCustomizer customOpenApi() {
        return openApi -> {
            openApi.getComponents()
                   .addSchemas("Student", new ObjectSchema().name("Student").addProperties("id", new StringSchema())
                                                            .addProperties("firstName", new StringSchema())
                                                            .addProperties("lastName", new StringSchema())
                                                            .addProperties("email", new StringSchema())
                                                            .addProperties("phone", new StringSchema())
                                                            .addProperties("address", new StringSchema()));
        };
    }


}