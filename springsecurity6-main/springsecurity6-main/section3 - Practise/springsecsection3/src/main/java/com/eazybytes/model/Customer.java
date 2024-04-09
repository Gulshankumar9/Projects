package com.eazybytes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

//this pojo class represent the database

/*
@Data: This annotation generates getters, setters, equals, hashCode, and toString methods automatically, reducing
boilerplate code.
@Getter/@Setter: These annotations generate individual getter and setter methods, respectively.

@NoArgsConstructor/@AllArgsConstructor: These annotations generate constructors without arguments (empty constructor)
 and with all arguments, respectively.

@Builder: This annotation creates a builder pattern for constructing complex objects.
* */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    /*all variables act as columns*/
    /*when strategy is native then sequence no is autocreated and autoincremented.*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String email;
    private String pwd;
    private String role;

}