package com.eazybytes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(length = 100, nullable = false) // Specify column details
    private String name;

    @Column(length = 100, nullable = false, unique = true) // Unique email constraint
    private String email;

    @Column(length = 20, nullable = false) // Adjust length if needed
    private String mobileNumber;

    @Column(length = 500, nullable = false) // Consider secure password hashing (not shown here)
    private String pwd;

    @Column(length = 100, nullable = false)
    private String role;

    @Temporal(TemporalType.DATE) // Specify date type for createDt
    private Date createDt;


}