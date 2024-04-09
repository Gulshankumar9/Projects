package com.springdocopenapi.greetings;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema
public class Greetings {

    @Schema
    private Integer id;
    @Schema(accessMode = Schema.AccessMode.AUTO)
    private String firstName;
    @Schema
    private String lastName;
    @Schema
    private String message;

    public Greetings() {
    }

    public Greetings(Integer id, String firstName, String lastName, String message) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}