package com.example.swaggercustomui.model;

import java.util.List;

public class RequestModel {
    private List<AttributeModel> headers;
    private List<AttributeModel> queryParameters;
    private List<AttributeModel> pathParameters;
    private AttributeModel body;

    private String mediaType;

    public RequestModel(List<AttributeModel> headers, List<AttributeModel> queryParameters,
                        List<AttributeModel> pathParameters, AttributeModel body, String mediaType) {
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.pathParameters = pathParameters;
        this.body = body;
        this.mediaType = mediaType;
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "RequestModel{" + "headers=" + headers + ", queryParameters=" + queryParameters + ", pathParameters=" + pathParameters + ", body=" + body + ", mediaType='" + mediaType + '\'' + '}';
    }
}