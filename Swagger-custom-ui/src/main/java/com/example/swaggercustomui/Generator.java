package com.example.swaggercustomui;

import com.example.swaggercustomui.model.ApiGroupModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class Generator {

    @Autowired
    private FetchData fetchData;

    {

    }

    public OpenAPI generate() {

        OpenAPI openAPI = this.generateOpenAPIDoc(this.readApiDefinitionsFromDatabase());

        return openAPI;
    }

    public List<ApiGroupModel> readApiDefinitionsFromDatabase() {

        //return fetchDataModel();

        return fetchData.fetch();
    }

    public OpenAPI generateOpenAPIDoc(List<ApiGroupModel> apiGroupModels) {


        return new DocBuilder().build(apiGroupModels);
    }


    public List<ApiGroupModel> fetchDataModel() {

        ObjectMapper objectMapper = new ObjectMapper();
        List<ApiGroupModel> modelobject = new ArrayList<ApiGroupModel>();
        TypeReference<List<ApiGroupModel>> typeRef = new TypeReference<List<ApiGroupModel>>() {
        };

        File file = new File("C:/Users/Gulshan/Desktop/projects/work/Swagger-custom-ui/src/main/resources/data.json");

        try {
            modelobject = objectMapper.readValue(file, typeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelobject;
    }

}