package com.example.customswaggerui.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Map;


public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;


    private String phone;


    private String address;
    @Schema(description = "List of Bpmclasses", implementation = Bpmclass.class)
    private List<Bpmclass> bpmclasses;

    private Map<String, String> task;

    private Map<String, Object> object;

    private Map<String, Map<String, Object>> map;

    private Map<Integer, String> map1;


    public Student(Long id, String firstName, String lastName, String email, String phone, String address,
                   List<Bpmclass> bpmclasses, Map<String, String> task, Map<String, Object> object, Map<String,
            Map<String, Object>> map, Map<Integer, String> map1) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.bpmclasses = bpmclasses;
        this.task = task;
        this.object = object;
        this.map = map;
        this.map1 = map1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bpmclass> getBpmclasses() {
        return bpmclasses;
    }

    public void setBpmclasses(List<Bpmclass> bpmclasses) {
        this.bpmclasses = bpmclasses;
    }

    public Map<String, String> getTask() {
        return task;
    }

    public void setTask(Map<String, String> task) {
        this.task = task;
    }

    @JsonAnyGetter
    public Map<String, Object> getObject() {
        return object;
    }

    @JsonAnySetter
    public void setObject(Map<String, Object> object) {
        this.object = object;
    }

    @JsonAnyGetter
    public Map<String, Map<String, Object>> getMap() {
        return map;
    }

    @JsonAnySetter
    public void setMap(Map<String, Map<String, Object>> map) {
        this.map = map;
    }

    @JsonAnyGetter
    public Map<Integer, String> getMap1() {
        return map1;
    }

    @JsonAnySetter
    public void setMap1(Map<Integer, String> map1) {
        this.map1 = map1;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", " + "email='" + email + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", " + "bpmclasses=" + bpmclasses + ", task=" + task + ", object=" + object + ", map=" + map + ", map1=" + map1 + '}';
    }
}