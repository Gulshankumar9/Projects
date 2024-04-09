package com.example.customswaggerui.models2;

import java.util.List;

public class ApiGroupModel {

    private String name;

    private String description;
    private List<ApiModel> apiModels;

    public ApiGroupModel() {
    }

    public ApiGroupModel(String name, String description, List<ApiModel> apiModels) {
        this.name = name;
        this.description = description;
        this.apiModels = apiModels;
    }

    @Override
    public String toString() {
        return "ApiGroupModel{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", apiModels=" + apiModels + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApiModel> getApiModels() {
        return apiModels;
    }

    public void setApiModels(List<ApiModel> apiModels) {
        this.apiModels = apiModels;
    }
}