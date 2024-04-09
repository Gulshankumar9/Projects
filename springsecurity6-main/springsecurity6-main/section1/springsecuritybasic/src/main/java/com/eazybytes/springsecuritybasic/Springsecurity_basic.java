package com.eazybytes.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.eazybytes.springsecuritybasic.controller") // Optional
public class Springsecurity_basic {

    public static void main(String[] args) {
        SpringApplication.run(Springsecurity_basic.class, args);
    }

}