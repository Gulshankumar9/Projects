package com.example.customswaggerui.models2;

import java.util.List;

public class ResponseModel {
    private List<AttributeModel> headers;
    private AttributeModel successResponse;
    private AttributeModel failureResponse;
    private String mediaType;

    public ResponseModel(List<AttributeModel> headers, AttributeModel successResponse, AttributeModel failureResponse
            , String mediaType) {
        this.headers = headers;
        this.successResponse = successResponse;
        this.failureResponse = failureResponse;
        this.mediaType = mediaType;
    }

    public ResponseModel() {
    }

    public List<AttributeModel> getHeaders() {
        return headers;
    }

    public void setHeaders(List<AttributeModel> headers) {
        this.headers = headers;
    }

    public AttributeModel getSuccessResponse() {
        return successResponse;
    }

    public void setSuccessResponse(AttributeModel successResponse) {
        this.successResponse = successResponse;
    }

    public AttributeModel getFailureResponse() {
        return failureResponse;
    }

    public void setFailureResponse(AttributeModel failureResponse) {
        this.failureResponse = failureResponse;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "ResponseModel{" + "headers=" + headers + ", successResponse=" + successResponse + ", failureResponse" +
                "=" + failureResponse + ", mediaType='" + mediaType + '\'' + '}';
    }
}