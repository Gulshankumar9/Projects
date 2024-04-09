package com.eazybytes.repository;

import com.eazybytes.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customer WHERE email = ?1", nativeQuery = true)
    List<Customer> findByEmail(String email);

}