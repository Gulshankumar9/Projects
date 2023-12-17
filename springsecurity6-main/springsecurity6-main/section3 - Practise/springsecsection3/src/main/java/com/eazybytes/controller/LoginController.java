package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//take data from user and save it in database.
//new rest service.
@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;
    //response entity data can be sent using postman.
    //below code is for the response entity to get the value and save in database.
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer =null;
        ResponseEntity response =null;
        try {
            savedCustomer=customerRepository.save(customer);
            if(savedCustomer.getId()>0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
            }
        }
        catch (Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Exception occured due to " + ex.getMessage());
        }

        return response;
    }
}
