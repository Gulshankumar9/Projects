package com.example.customswaggerui;

import com.example.customswaggerui.models2.ApiGroupModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Configuration
//@ComponentScan(basePackages = "com.example.customswaggerui")
@ConditionalOnProperty(prefix = "springdoc", name = "swagger-ui.enabled", havingValue = "true")
public class Configurer {


    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Bean
    public OpenApiCustomizer customOpenApi() {

        Components components = new Components();
        List<ApiGroupModel> apiGroupModels = fetchDataModel();

        return openApi -> {
            apiGroupModels.forEach(apiGroupModel -> {
                apiGroupModel.getApiModels().forEach(apiModel -> {
                    // Add the "Student" schema
                    openApi.getComponents().addSchemas(apiModel.getRequest().getBody()
                                                               .getName(), DocBuilder.convertJavaClassToSchema((apiModel
                            .getRequest().getBody().getDataType())));
                });
            });

        };
    }

    @Bean
    public OpenAPI openAPI() {

        List<ApiGroupModel> modelobject = fetchDataModel();

        modelobject.forEach(System.out::println);

        return new Generator().generate(modelobject);
    }

    public List<ApiGroupModel> fetchDataModel() {

        System.out.println("Fetching Data Model" + studentRepository.findAll());

        System.out.println("Fetching Data Model" + teacherRepository.findAll());


        ObjectMapper objectMapper = new ObjectMapper();
        List<ApiGroupModel> modelobject = new ArrayList<ApiGroupModel>();
        TypeReference<List<ApiGroupModel>> typeRef = new TypeReference<List<ApiGroupModel>>() {
        };

        File file = new File("C:/Users/Gulshan/Desktop/projects/work/custom-swagger-ui/src/main/resources/data.json");

        try {
            modelobject = objectMapper.readValue(file, typeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelobject;
    }
}