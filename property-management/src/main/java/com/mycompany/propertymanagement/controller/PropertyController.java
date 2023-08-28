package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.propertydto;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

public class PropertyController {

    @Autowired
    private PropertyService propertyService;


    //http://localhost:8080/api/v1/properties/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello ";
    }


    @PostMapping("/properties")
    public ResponseEntity<propertydto> saveproperty(@RequestBody propertydto pdto){

        pdto=propertyService.saveProperty(pdto);
        ResponseEntity<propertydto>responseEntity=new ResponseEntity<>(pdto, HttpStatus.CREATED);

        return responseEntity;
    }
}
