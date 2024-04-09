package com.example.swaggercustomui.model;

public class ApiModel {

    private String uri;
    private String summary;
    private String description;
    private String httpMethod;
    private RequestModel request;
    private ResponseModel response;

    public ApiModel() {
    }

    public ApiModel(String uri, String summary, String description, String httpMethod, RequestModel request,
                    ResponseModel response) {
        this.uri = uri;
        this.summary = summary;
        this.description = description;
        this.httpMethod = httpMethod;
        this.request = request;
        this.response = response;
    }

    @Override
    public String toString() {
        return "ApiModel{" + "uri='" + uri + '\'' + ", summary='" + summary + '\'' + ", description='" + description + '\'' + ", httpMethod='" + httpMethod + '\'' + ", request=" + request + ", response=" + response + '}';
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public RequestModel getRequest() {
        return request;
    }

    public void setRequest(RequestModel request) {
        this.request = request;
    }

    public ResponseModel getResponse() {
        return response;
    }

    public void setResponse(ResponseModel response) {
        this.response = response;
    }
}