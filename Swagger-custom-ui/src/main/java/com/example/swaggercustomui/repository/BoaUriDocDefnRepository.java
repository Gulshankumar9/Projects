package com.example.swaggercustomui.repository;

import com.example.swaggercustomui.persistance.BoaUriDocDefn;
import com.example.swaggercustomui.persistance.BoaUriDocDefnId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoaUriDocDefnRepository extends JpaRepository<BoaUriDocDefn, BoaUriDocDefnId> {
}