package com.springdocopenapi.customapi;

import com.springdocopenapi.greetings.Greetings;
import com.springdocopenapi.greetings.GreetingsRepository;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    /*@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Custom API").version("1.0").description("This is a custom API")
                                            .termsOfService("http://swagger.io/terms/")
                                            .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }*/

    /*@Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI().info(new Info().title("Custom API").version("1.0")
                                                       .description("This is a custom API")
                                                       .termsOfService("http://swagger.io/terms/")
                                                       .license(new License().name("Apache 2.0")
                                                                             .url("http://springdoc.org")));

        // Create a custom path
        PathItem pathItem = new PathItem().get(new Operation().operationId("myOperation")
                                                              .description("This is a custom operation")
                                                              .responses(new ApiResponses().addApiResponse("200",
                                                                      new ApiResponse().description("Successful " +
                                                                              "operation"))));

        // Add the path to the OpenAPI object
        openAPI.paths(new Paths().addPathItem("/myPath", pathItem));

        return openAPI;
    }*/

    /*@Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI().info(new Info().title("Custom API").version("1.0")
                                                       .description("This is a custom API")
                                                       .termsOfService("http://swagger.io/terms/")
                                                       .license(new License().name("Apache 2.0")
                                                                             .url("http://springdoc.org")));

        // Define the ModelClass schema
        Schema modelClassSchema = new Schema().addProperties("id", new StringSchema())
                                              .addProperties("name", new StringSchema())
                                              .addProperties("description", new StringSchema());

        // Create a custom path for each CRUD operation
        PathItem pathItem = new PathItem()
                .get(new Operation().operationId("getModelClass").description("Get a ModelClass instance")
                                    .responses(new ApiResponses().addApiResponse("200", new ApiResponse()
                                            .description("Successful operation")
                                            .content(new Content().addMediaType("application/json",
                                                    new MediaType().schema(modelClassSchema))))))
                .post(new Operation().operationId("createModelClass").description("Create a new ModelClass instance")
                                     .requestBody(new RequestBody().content(new Content().addMediaType("application"
                                     + "/json", new MediaType().schema(modelClassSchema))))
                                     .responses(new ApiResponses().addApiResponse("201", new ApiResponse()
                                             .description("ModelClass instance created")
                                             .content(new Content().addMediaType("application/json",
                                                     new MediaType().schema(modelClassSchema))))))
                .put(new Operation().operationId("updateModelClass").description("Update a ModelClass instance")
                                    .requestBody(new RequestBody().content(new Content().addMediaType("application" +
                                     "/json", new MediaType().schema(modelClassSchema))))
                                    .responses(new ApiResponses().addApiResponse("200", new ApiResponse()
                                            .description("ModelClass instance updated")
                                            .content(new Content().addMediaType("application/json",
                                                    new MediaType().schema(modelClassSchema))))))
                .delete(new Operation().operationId("deleteModelClass").description("Delete a ModelClass instance")
                                       .responses(new ApiResponses().addApiResponse("204",
                                               new ApiResponse().description("ModelClass instance deleted"))));

        // Add the path to the OpenAPI object
        openAPI.paths(new Paths().addPathItem("/myPath", pathItem));

        return openAPI;
    }*/




    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI().info(new Info().title("Custom API").version("1.0")
                                                       .description("This is a custom API")
                                                       .termsOfService("http://swagger.io/terms/")
                                                       .license(new License().name("Apache 2.0")
                                                                             .url("http://springdoc.org")));

        /*// Define the ModelClass schema
        Schema modelClassSchema = new Schema().addProperties("id", new StringSchema())
                                              .addProperties("name", new StringSchema())
                                              .addProperties("description", new StringSchema());*/


        // Define the ModelClass schema
        // Define the ModelClass schema
        Schema modelClassSchema = new Schema().addProperties("firstName", new StringSchema())
                                              .addProperties("lastName", new StringSchema())
                                              .addProperties("message", new StringSchema());

        // Add the ModelClass schema to the components
        openAPI.components(new Components().addSchemas("ModelClass", modelClassSchema));


        // Create a custom path for each CRUD operation
        PathItem getPathItem = new PathItem().get(new Operation().operationId("getGreetings")
                                                                 .description("Get a ModelClass instance of Greetings")
                                                                 .addParametersItem(new Parameter().in("query")
                                                                                                   .name("id")
                                                                                                   .description("The "
                                                                                                           + "ID of " + "the" + " " + "Greetings instance")
                                                                                                   .required(true)
                                                                                                   .schema(new Schema().type("string")))
                                                                 .responses(new ApiResponses().addApiResponse("200",
                                                                         new ApiResponse()
                                                                         .description("Successful operation")
                                                                         .content(new Content()
                                                                                 .addMediaType("application/json",
                                                                                         new MediaType().schema(modelClassSchema))
                                                                                 .addMediaType("application/xml",
                                                                                         new MediaType().schema(modelClassSchema))))));




        PathItem postPathItem = new PathItem().post(new Operation().operationId("create Greetings Class")
                                                                   .description("Create a new ModelClass instance")
                                                                   .addParametersItem(new Parameter().in("query")
                                                                                                     .name("id")
                                                                                                     .description(
                                                                                                             "The " + "ID of " + "the" + " " + "ModelClass instance")
                                                                                                     .required(true)
                                                                                                     .schema(new Schema().type("string")))
                                                                   .requestBody(new RequestBody().content(new Content().addMediaType("application/json", new MediaType().schema(modelClassSchema))))
                                                                   .responses(new ApiResponses().addApiResponse("201"
                                                                           , new ApiResponse()
                                                                           .description("ModelClass instance created")
                                                                           .content(new Content()
                                                                                   .addMediaType("application/json",
                                                                                           new MediaType().schema(modelClassSchema))
                                                                                   .addMediaType("application/xml",
                                                                                           new MediaType().schema(modelClassSchema))))));

        PathItem putPathItem = new PathItem().put(new Operation().operationId("updateModelClass")
                                                                 .description("Update a ModelClass instance")
                                                                 .addParametersItem(new Parameter().in("query")
                                                                                                   .name("id")
                                                                                                   .description("The "
                                                                                                           + "ID of " + "the" + " " + "ModelClass instance")
                                                                                                   .required(true)
                                                                                                   .schema(new Schema().type("string")))
                                                                 .requestBody(new RequestBody().content(new Content().addMediaType("application/json", new MediaType().schema(modelClassSchema))))
                                                                 .responses(new ApiResponses().addApiResponse("200",
                                                                         new ApiResponse()
                                                                         .description("ModelClass instance updated")
                                                                         .content(new Content()
                                                                                 .addMediaType("application/json",
                                                                                         new MediaType().schema(modelClassSchema))
                                                                                 .addMediaType("application/xml",
                                                                                         new MediaType().schema(modelClassSchema))))));

        PathItem deletePathItem = new PathItem().delete(new Operation().operationId("deleteModelClass")
                                                                       .description("Delete a ModelClass instance")
                                                                       .addParametersItem(new Parameter().in("query")
                                                                                                         .name("id")
                                                                                                         .description("The " + "ID of " + "the" + " " + "ModelClass instance")
                                                                                                         .required(true)
                                                                                                         .schema(new Schema().type("string")))
                                                                       .responses(new ApiResponses().addApiResponse(
                                                                               "204", new ApiResponse()
                                                                               .description("ModelClass instance " +
                                                                                       "deleted")
                                                                               .content(new Content()
                                                                                       .addMediaType("application" +
                                                                                               "/json",
                                                                                               new MediaType().schema(modelClassSchema))
                                                                                       .addMediaType("application/xml"
                                                                                               ,
                                                                                               new MediaType().schema(modelClassSchema))))));

        // Add the paths to the OpenAPI object
        openAPI.paths(new Paths().addPathItem("/myPath/get", getPathItem).addPathItem("/myPath/post", postPathItem)
                                 .addPathItem("/myPath/put", putPathItem)
                                 .addPathItem("/myPath/delete", deletePathItem));

        return openAPI;
    }
}