package com.example.swaggercustomui.model;

public class AttributeModel {

    private String name;
    private String dataType;
    private String summary;
    private String description;
    private boolean mandatory;

    public AttributeModel() {
    }

    public AttributeModel(String name, String dataType, String summary, String description, boolean mandatory) {
        this.name = name;
        this.dataType = dataType;
        this.summary = summary;
        this.description = description;
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "AttributeModel{" + "name='" + name + '\'' + ", dataType='" + dataType + '\'' + ", summary='" + summary + '\'' + ", description='" + description + '\'' + ", mandatory=" + mandatory + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}