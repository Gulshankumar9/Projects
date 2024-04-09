package com.example.customswaggerui.models2;

import java.util.List;

public class RequestModel {
    private List<AttributeModel> headers;
    private List<AttributeModel> queryParameters;
    private List<AttributeModel> pathParameters;
    private AttributeModel body;

    public RequestModel(List<AttributeModel> headers, List<AttributeModel> queryParameters,
                        List<AttributeModel> pathParameters, AttributeModel body) {
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.pathParameters = pathParameters;
        this.body = body;
    }

    public RequestModel() {
    }

    public List<AttributeModel> getHeaders() {
        return headers;
    }

    public void setHeaders(List<AttributeModel> headers) {
        this.headers = headers;
    }

    public List<AttributeModel> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(List<AttributeModel> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public List<AttributeModel> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(List<AttributeModel> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public AttributeModel getBody() {
        return body;
    }

    public void setBody(AttributeModel body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RequestModel{" + "headers=" + headers + ", queryParameters=" + queryParameters + ", pathParameters=" + pathParameters + ", body=" + body + '}';
    }
}