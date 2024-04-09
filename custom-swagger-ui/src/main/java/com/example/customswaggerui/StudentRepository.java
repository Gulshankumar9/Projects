package com.example.customswaggerui;

import com.example.customswaggerui.models.Students;
import com.example.customswaggerui.models.StudentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, StudentsId> {
}