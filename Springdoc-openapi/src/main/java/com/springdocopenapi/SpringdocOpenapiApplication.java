package com.springdocopenapi;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdocOpenapiApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringdocOpenapiApplication.class, args);

    }

    @Bean
    public GroupedOpenApi studentOpenApi(@Value("v1.0") String appVersion) {
        String[] studentPaths = {"/Students/**"}; // Assuming all student paths start with /students
        return GroupedOpenApi.builder().group("students")
                             .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Students API")
                                                                                     .version(appVersion)))
                             .pathsToMatch(studentPaths).build();
    }

    @Bean
    public GroupedOpenApi customOpenApi(@Value("v1.0") String appVersion) {
        String[] greetPaths = {"/myPath/**"}; // Assuming all custom paths start with /myPath
        return GroupedOpenApi.builder().group("custom")
                             .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Custom API")
                                                                                     .version(appVersion)))
                             .pathsToMatch(greetPaths).build();
    }

    @Bean
    public GroupedOpenApi allOpenApi(@Value("v1.0") String appVersion) {
        String[] allPaths = {"/**"}; // Matches all paths
        return GroupedOpenApi.builder().group("all")
                             .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("All API")
                                                                                     .version(appVersion)))
                             .pathsToMatch(allPaths).build();
    }
}