package com.example.swaggercustomui;

/*import com.example.customswaggerui.models.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victools.jsonschema.generator.*;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
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

import java.util.ArrayList;
import java.util.List;*/

import com.example.swaggercustomui.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.converter.ModelConverterContextImpl;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.core.util.Json;
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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DocBuilder {
    /*public Schema convertJavaClassToSchema(String path) {

        try {
            Class<?> className = Class.forName(path);

            SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12,

                    OptionPreset.PLAIN_JSON);

            SchemaGeneratorConfig config = configBuilder.with(Option.INLINE_ALL_SCHEMAS).build();

            SchemaGenerator generator = new SchemaGenerator(config);

            JsonNode jsonSchema = generator.generateSchema(className);

            System.out.println(jsonSchema.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            Schema schema = objectMapper.convertValue(jsonSchema, Schema.class);

            return schema;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }*/

    public Schema convertJavaClassToSchema(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ModelResolver modelResolver = new ModelResolver(objectMapper);
            Class<?> className = Class.forName(path);
            AnnotatedType annotatedType = new AnnotatedType().type(className);
            ModelConverterContextImpl context = new ModelConverterContextImpl(modelResolver);
            Schema schema = modelResolver.resolve(annotatedType, context, null);

            //OpenAPI openAPI = new OpenAPI();
            //openAPI.schema(schema.getName(), schema);

            return schema;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    public OpenAPI build(List<ApiGroupModel> apiGroupModels) {

        OpenAPI openAPI = new OpenAPI();
        List<ApiModel> apiModelList = new ArrayList<>();
        apiGroupModels.forEach(groupModel -> {

            /*openAPI.info(new Info().title(groupModel.getName()).version("1.0")
                                   .description(groupModel.getDescription()));

            // Create a tag for this group
            Tag tag = new Tag().name(groupModel.getName()).description(groupModel.getDescription());
            openAPI.addTagsItem(tag);

            */


        });
        openAPI.setPaths(this.buildIndividualApiDoc(apiGroupModels));
        return openAPI;
    }

    private Paths buildIndividualApiDoc(List<ApiGroupModel> apiGroupModels) {

        Paths paths = new Paths();

        apiGroupModels.forEach(apiGroupModel -> {

            apiGroupModel.getApiModels().forEach(apiModel -> {

                PathItem pathItem = new PathItem();

                HttpMethod httpMethod = HttpMethod.valueOf(apiModel.getHttpMethod());

                ApiResponses apiResponses = new ApiResponses();

                Operation operation = new Operation().description(apiModel.getDescription())
                                                     .summary(apiModel.getSummary())
                                                     .addTagsItem(apiGroupModel.getName());

                switch (httpMethod) {
                    case GET:

                        List<Parameter> parameters = this.addParameterDataList(apiModel.getRequest()
                                                                                       .getQueryParameters());
                        parameters.forEach(operation::addParametersItem);

                        pathItem.get(operation.responses(apiResponses.addApiResponse("200",
                                this.buildResponseData(apiModel.getResponse()))));
                        //paths.addPathItem(apiModel.getUri(), pathItem);
                        break;
                    case POST:

                        List<Parameter> postparameters = this.addParameterDataList(apiModel.getRequest()
                                                                                           .getQueryParameters());
                        postparameters.forEach(operation::addParametersItem);
                        pathItem.post(operation.description(apiModel.getDescription()).summary(apiModel.getSummary())
                                               .requestBody(this.buildRequestData(apiModel.getRequest(),
                                                       apiModel.getResponse()))
                                               .addTagsItem(apiGroupModel.getName())
                                               .responses(apiResponses.addApiResponse("200",
                                                       this.buildResponseData(apiModel.getResponse()))));
                        //paths.addPathItem(apiModel.getUri(), pathItem);
                        break;
                    case PUT:
                        pathItem.put(operation.description(apiModel.getDescription()).summary(apiModel.getSummary())
                                              .requestBody(this.buildRequestData(apiModel.getRequest(),
                                                      apiModel.getResponse()))
                                              .addTagsItem(apiGroupModel.getName())

                                              .responses(apiResponses.addApiResponse("200",
                                                      this.buildResponseData(apiModel.getResponse()))));
                        //paths.addPathItem(apiModel.getUri(), pathItem);
                        break;
                    case PATCH:
                        pathItem.patch(operation.description(apiModel.getDescription()).summary(apiModel.getSummary())
                                                .requestBody(this.buildRequestData(apiModel.getRequest(),
                                                        apiModel.getResponse()))
                                                .addTagsItem(apiGroupModel.getName())
                                                .responses(apiResponses.addApiResponse("200",
                                                        this.buildResponseData(apiModel.getResponse()))));
                        //paths.addPathItem(apiModel.getUri(), pathItem);
                        break;
                }
                paths.addPathItem(apiModel.getUri(), pathItem);
            });

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

        apiResponse.content(new Content().addMediaType(responseModel.getMediaType(), new MediaType()
                           .schema(this.convertJavaClassToSchema(responseModel.getSuccessResponse().getDataType())
                                       .name(responseModel.getSuccessResponse().getName()))
                           .example(this.convertJavaClassToSchema(responseModel.getSuccessResponse().getDataType()))))
                   .description(responseModel.getSuccessResponse().getDescription());
        return apiResponse;

    }

    public RequestBody buildRequestData(RequestModel requestModel, ResponseModel responseModel) {

        RequestBody requestBody = new RequestBody();

        requestBody.content(new Content().addMediaType(requestModel.getMediaType(), new MediaType()
                .schema(this.convertJavaClassToSchema(requestModel.getBody().getDataType())
                            .name(requestModel.getBody().getName()))
                .example(this.convertJavaClassToSchema(requestModel.getBody().getDataType()))));

        return requestBody;
    }


}