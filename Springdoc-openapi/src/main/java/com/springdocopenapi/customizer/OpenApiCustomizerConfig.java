package com.springdocopenapi.customizer;

import com.springdocopenapi.student.ApiMetaDataModel;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
@Configuration
public class OpenApiCustomizerConfig {
    @Bean
    public OpenApiCustomizer openApiCustomiser() {

        List<ApiMetaDataModel> apiMetadataModels = this.getApiMetadataModels();
        final Map<String, PathItem> all = new HashMap<>();
        apiMetadataModels.forEach(apiMetadata -> {

            all.put("POST", this.buildPathItem(apiMetadata));

        });
        return openAPI -> openAPI.getPaths().putAll(all);
    }

    private List<ApiMetaDataModel> getApiMetadataModels() {
        return List.of(new ApiMetaDataModel());
    }

    private PathItem buildPathItem(ApiMetaDataModel apiMetadata) {
        PathItem pathItem = new PathItem();

        // construct query parameters
        */
/*List<Parameter> parameters = new ArrayList<>();
        apiMetadata.getQuery().forEach((key, value) -> parameters.add(new Parameter().name(key)
                                                                                     // name of query parameter
                                                                                     .required(value.isMandatory())
                                                                                     .description(key)
                                                                                     // description
                                                                                     // query of parameter
                                                                                     .in("query")
                                                                                     .schema(new Schema().type(value
                                                                                     .getDataType()))));
        // set type of parameters
*//*

        // construct request body

        // Map<String, Schema> bodyProperties constructBodyProperties (apiMetadata.getBody());

        // construct response information

        */
/*ApiResponses apiResponses = new ApiResponses();
        HttpStatus httpStatus = HttpStatus.valueOf(apiMetadata.getResponse().getStatus());
        apiResponses.addApiResponse(String.valueOf(httpStatus.value()),
                new ApiResponse().description(httpStatus.getReasonPhrase()));

        // construct Operation Object

        Operation operation = new Operation().operationId(apiMetadata.getCode())
                                             .description(apiMetadata.getDescription()).summary(apiMetadata.getName())
                                             .addTagsItem("sas-scenario").responses(apiResponses);

        // tags to group the newly
        // only add response body if the http method is not head and get

        if (!Arrays.asList(HttpMethod.GET.name(), HttpMethod.HEAD.name()).contains(apiMetadata.getMethod())) {
            operation.setRequestBody(new RequestBody().content(new Content().addMediaType("application/json",
                    new MediaType().schema(new Schema().type("object")))));
        }

        pathItem.operation(PathItem.HttpMethod.valueOf(apiMetadata.getMethod().toString()), operation);
        return pathItem;
    }*//*




















*/
/*private Map<String, Schema> constructBodyProperties(Map<String, ScenarioConfigRequestObject> body) {

        Map<String, Schema> requestBodyProperties new HashMap<>();

        body.forEach((key, value) -> {

            // generate array scema for list of object

            if ("LIST".equalsIgnoreCase(value.getDataType())) {

                ArraySchema arraySchema = new ArraySchema().items(

                        new Schema<>().type("object").description(key)
                                      .properties(constructBodyProperties(value.getBody())));

                requestBodyProperties.put(key, arraySchema);

            } else {

                Schema schema = new Schema().type(translateType(value.getDataType())).description(key);

                if ("MAP".equalsIgnoreCase(value.getDataType())) {

                    // if the object is map, need to call the method recursively

                    schema.setProperties(constructBodyProperties(value.getBody()));

                }

                requestBodyProperties.put(key, schema);
            }
        });
        return requestBodyProperties;
    }

}

 */