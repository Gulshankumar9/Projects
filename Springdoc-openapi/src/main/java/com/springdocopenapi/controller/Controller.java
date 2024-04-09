package com.springdocopenapi.controller;

import com.springdocopenapi.greetings.GreetingsRepository;
import com.springdocopenapi.student.Student;
import com.springdocopenapi.student.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name = "Student Api", description = "Manage students from controller")
public class Controller {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GreetingsRepository greetingsRepository;


    /*@GetMapping("/helloworld")
    @Operation(summary = "Find all students", description = "Returns a list of all students")
    public String hello() {
        return "Hello, World!";
    }*/

    /*@GetMapping("/myPath/get")
    public List<?> getall() {
        return greetingsRepository.getAll();
    }*/

    @GetMapping("/Students")
    @Operation(summary = "Find all students", description = "Returns a list of all students")
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @GetMapping("/Students/{id}")
    @Operation(summary = "Find student with id", description = "Returns a student of the given id")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.getById(id);
    }

    @PostMapping("/Students")
    @Operation(summary = "Create a new student", description = "Creates and returns a new student")
    public Student createNewStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @PutMapping("/Students/{id}")
    @Operation(summary = "Update an existing student", description = "Updates and returns an existing student")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        newStudent.setId(id);
        return studentRepository.update(newStudent);
    }

    @DeleteMapping("/Students/{id}")
    @Operation(summary = "Delete a student by id", description = "Deletes a student with the given id")
    public void deleteStudent(@PathVariable @Parameter(description = "The id of the student to be deleted") Long id) {
        studentRepository.delete(id);
    }
}