package com.springdocopenapi.student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices implements StudentRepository {

    private static List<Student> students = new ArrayList<>();

    public StudentServices() {
        // initialize test data
        students.add(new Student(1L, "John", "Doe", "john@simplesolution.dev", "123-456-789", "address 123, street 1, city 1"));
        students.add(new Student(2L, "Emerson", "Wilks", "emerson@simplesolution.dev", "123-456-788", "address 456, street 2, city 1"));
        students.add(new Student(3L, "Wade", "Savage", "wade@simplesolution.dev", "123-456-787", "address 789, street 3, city 1"));
        students.add(new Student(4L, "Star", "Lott", "star@simplesolution.dev", "123-456-786", "address 234, street 4, city 1"));
        students.add(new Student(5L, "Claudia", "James", "claudia@simplesolution.dev", "123-456-785", "address 678, street 5, city 1"));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student getById(Long id) {
        Student result = students.stream().filter(Student -> Student.getId().equals(id)).findAny().orElse(null);
        return result;
    }

    @Override
    public Student save(Student newStudent) {
        students.add(newStudent);
        return newStudent;
    }

    @Override
    public Student update(Student newStudent) {
        Student currentStudent = students.stream().filter(Student -> Student.getId().equals(newStudent.getId())).findAny().orElse(null);
        currentStudent.setFirstName(newStudent.getFirstName());
        currentStudent.setLastName(newStudent.getLastName());
        currentStudent.setEmail(newStudent.getEmail());
        currentStudent.setPhone(newStudent.getPhone());
        currentStudent.setAddress(newStudent.getAddress());
        return currentStudent;
    }

    @Override
    public void delete(Long id) {
        Student currentStudent = students.stream().filter(Student -> Student.getId().equals(id)).findAny().orElse(null);
        students.remove(currentStudent);
    }
}