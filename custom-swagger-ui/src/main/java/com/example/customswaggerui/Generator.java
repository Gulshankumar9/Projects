package com.example.customswaggerui;

import com.example.customswaggerui.models2.ApiGroupModel;
import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

public class Generator {

    public OpenAPI generate(List<ApiGroupModel> apiGroupModels) {
        this.readApiDefinitionsFromDatabase();

        OpenAPI openAPI = this.generateOpenAPIDoc(this.buildApiModels(apiGroupModels));

        return openAPI;
    }

    public void readApiDefinitionsFromDatabase() {

    }

    public List<ApiGroupModel> buildApiModels(List<ApiGroupModel> apiGroupModels) {

        List<ApiGroupModel> list = apiGroupModels;

        return list;
    }

    public OpenAPI generateOpenAPIDoc(List<ApiGroupModel> apiGroupModels) {

        return new DocBuilder().build(apiGroupModels);
    }
}