package com.example.swaggercustomui;

import com.example.swaggercustomui.model.ApiGroupModel;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
//@ComponentScan(basePackages = "com.example.customswaggerui")
@ConditionalOnProperty(prefix = "springdoc", name = "swagger-ui.enabled", havingValue = "true")
public class Configurer {


    @Autowired
    private Generator generator;

    @Autowired
    private DocBuilder docBuilder;

    @Bean
    public OpenApiCustomizer customOpenApi() {

        Components components = new Components();
        List<ApiGroupModel> apiGroupModels = generator.readApiDefinitionsFromDatabase();

        return openApi -> {
            apiGroupModels.forEach(apiGroupModel -> {
                apiGroupModel.getApiModels().forEach(apiModel -> {
                    // Add the "Student" schema

                    // Add the schema
                    openApi.getComponents().addSchemas(apiModel.getRequest().getBody()
                                                               .getName(), docBuilder.convertJavaClassToSchema((apiModel
                            .getRequest().getBody().getDataType())));

                });
            });

        };
    }

    @Bean
    public OpenAPI openAPI() {


        return generator.generate();
    }
}