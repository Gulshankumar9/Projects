package com.example.customswaggerui.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "students")
public class Students {

    @EmbeddedId
    private StudentsId student_id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "subject_id")
    private int subject_id;

    public Students(StudentsId student_id, String student_name, int subject_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.subject_id = subject_id;
    }

    public Students() {
    }

    public StudentsId getStudent_id() {
        return student_id;
    }

    public void setStudent_id(StudentsId student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    @Override
    public String toString() {
        return "Students{" + "student_id=" + student_id + ", student_name='" + student_name + '\'' + ", subject_id=" + subject_id + '}';
    }
}