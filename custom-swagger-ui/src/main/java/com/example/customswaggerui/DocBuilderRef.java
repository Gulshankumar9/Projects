/*
package com.example.customswaggerui;

import com.example.customswaggerui.models.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DocBuilderRef {

    public OpenAPI build(List<ApiGroupModel> apiGroupModels) {

        OpenAPI openAPI = new OpenAPI();

        List<ApiModel> apiModelList = new ArrayList<>();

        apiGroupModels.forEach(groupModel -> {

            */
/*openAPI.info(new Info().title(groupModel.getName()).version("1.0")
                                   .description(groupModel.getDescription()));*//*


            groupModel.getApiModels().forEach(apiModel -> {


                apiModelList.add(apiModel);
            });

            buildGroupedPaths(apiGroupModels);

        });

        openAPI.setPaths(this.buildIndividualApiDoc(apiModelList));

        return openAPI;

    }


    private Paths buildGroupedPaths(List<ApiGroupModel> apiGroupModels) {
        Paths paths = new Paths();

        for (ApiGroupModel groupModel : apiGroupModels) {
            // Extract relevant information for tag creation (optional)
            String groupName = groupModel.getName(); // Customize based on your data
            String groupDescription = groupModel.getDescription(); // Customize based on your data

            // Iterate through API models within the group
            for (ApiModel apiModel : groupModel.getApiModels()) {
                PathItem pathItem = buildIndividualApiDoc(Collections.singletonList(apiModel)).get(apiModel.getUri()); // Retrieve the PathItem for the current API model

                // Optionally create and add a tag based on group information
                if (groupName != null && groupDescription != null) {
                    Tag groupTag = new Tag().name(groupName).description(groupDescription);
                    for (Map.Entry<String, Operation> entry : pathItem.entrySet()) { // Iterate through path item entries
                        Operation operation = entry.getValue();
                        operation.addTagsItem(groupTag.getName()); // Use the tag name
                    }
                }

                paths.addPathItem(apiModel.getUri(), pathItem); // Add the PathItem to Paths
            }
        }

        return paths;
    }




    private Paths buildIndividualApiDoc(List<ApiModel> apiModelList) {

        Paths paths = new Paths();

        apiModelList.forEach(apiModel -> {
            PathItem pathItem = new PathItem();

            HttpMethod httpMethod = HttpMethod.valueOf(apiModel.getHttpMethod());

            ApiResponses apiResponses = new ApiResponses();

            switch (httpMethod) {
                case GET:
                    Operation operation = new Operation().description(apiModel.getDescription())
                                                         .summary(apiModel.getSummary());

                    List<Parameter> parameters = this.addParameterDataList(apiModel.getRequest().getQueryParameters());

                    parameters.forEach(operation::addParametersItem);

                    pathItem.get(operation.responses(apiResponses.addApiResponse("200",
                            this.buildResponseData(apiModel.getResponse()))));

                    paths.addPathItem(apiModel.getUri(), pathItem);
                    break;
                case POST:
                    pathItem.post(new Operation().description(apiModel.getDescription()).summary(apiModel.getSummary())
                                                 .requestBody(this.buildRequestData(apiModel.getRequest(),
                                                         apiModel.getResponse()))

                                                 .responses(apiResponses.addApiResponse("200",
                                                         this.buildResponseData(apiModel.getResponse()))));
                    paths.addPathItem(apiModel.getUri(), pathItem);
                    break;
                case PUT:
                    pathItem.put(new Operation().description(apiModel.getDescription()).summary(apiModel.getSummary())
                                                .requestBody(this.buildRequestData(apiModel.getRequest(),
                                                        apiModel.getResponse()))

                                                .responses(apiResponses.addApiResponse("200",
                                                        this.buildResponseData(apiModel.getResponse()))));
                    paths.addPathItem(apiModel.getUri(), pathItem);
                    break;
                case PATCH:
                    pathItem.patch(new Operation().description(apiModel.getDescription()).summary(apiModel.getSummary())
                                                  .requestBody(this.buildRequestData(apiModel.getRequest(),
                                                          apiModel.getResponse()))

                                                  .responses(apiResponses.addApiResponse("200",
                                                          this.buildResponseData(apiModel.getResponse()))));
                    paths.addPathItem(apiModel.getUri(), pathItem);
                    break;
            }
        });
        return paths;
    }


    private List<Parameter> addParameterDataList(List<AttributeModel> attributeModels) {

        List<Parameter> parametersList = new ArrayList<>();
        attributeModels.forEach(attributeModel -> {

            Schema schema = new Schema<>();
            schema.setType(attributeModel.getDataType());
            Parameter parameter = new Parameter();

            parameter.in("query").name(attributeModel.getName()).description(attributeModel.getDescription())
                     .required(attributeModel.isMandatory()).schema(schema);
            parametersList.add(parameter);
        });
        return parametersList;
    }


    private ApiResponse buildResponseData(ResponseModel responseModel) {

        ApiResponse apiResponse = new ApiResponse();

        apiResponse
                .content(new Content().addMediaType(responseModel.getMediaType(),
                        new MediaType().example(responseModel.getSuccessResponse())))
                .description(responseModel.getSuccessResponse().getDescription());
        return apiResponse;

    }

    public RequestBody buildRequestData(RequestModel requestModel, ResponseModel responseModel) {

        RequestBody requestBody = new RequestBody();

        Schema schema = new Schema();
        schema.set$ref("#/components/schemas/" + requestModel.getBody().getName());
        // Set the reference to the schema of
        // your POJO class
        requestBody.content(new Content().addMediaType(responseModel.getMediaType(), new MediaType()
                .example(requestModel.getBody()).schema(schema)));

        return requestBody;
    }
}*/