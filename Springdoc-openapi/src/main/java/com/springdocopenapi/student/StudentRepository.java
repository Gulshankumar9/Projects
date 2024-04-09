package com.springdocopenapi.student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();

    Student getById(Long id);

    Student save(Student newStudent);

    Student update(Student newStudent);

    void delete(Long id);
}