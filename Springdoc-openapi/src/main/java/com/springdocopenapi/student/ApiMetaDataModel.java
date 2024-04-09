package com.springdocopenapi.student;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.util.Map;

enum HttpMethod {
    GET, POST, PUT, DELETE, HEAD, PATCH, OPTIONS, TRACE
}

public class ApiMetaDataModel {
    private String code;
    private String description;
    private String name;
    private HttpMethod method = HttpMethod.GET;
    private ResponseModel response = new ResponseModel();
    private Map<String, QueryModel> query;

    private BodyModel body;

    // getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public ResponseModel getResponse() {
        return response;
    }

    public void setResponse(ResponseModel response) {
        this.response = response;
    }

    public Map<String, QueryModel> getQuery() {
        return query;
    }

    public void setQuery(Map<String, QueryModel> query) {
        this.query = query;
    }

    public BodyModel getBody() {
        return body;
    }

    public void setBody(BodyModel body) {
        this.body = body;
    }
}

class ResponseModel {
    private int status = HttpStatus.OK.value();
    private String description;
    private Schema schema;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }
}

class QueryModel {
    private boolean isMandatory;
    private String dataType;

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}

class BodyModel {
    // Define the fields of the request body here

    // getters and setters
}