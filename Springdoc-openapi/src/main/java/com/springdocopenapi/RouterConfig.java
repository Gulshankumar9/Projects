package com.springdocopenapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/*
@Configuration
public class RouterConfig {


    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route().GET("/greet", request -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).bodyValue("Hello, World!")).POST("/greet/post", this::greet).build();
    }


    private Mono<ServerResponse> greet(ServerRequest request) {
        Mono<Greetings> greeting = request.bodyToMono(Greetings.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(greeting, Greetings.class);
    }
}*/