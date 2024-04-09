package com.example.customswaggerui.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentsId implements Serializable {

    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "university_id")
    private Integer university_id;

    public StudentsId() {
    }

    public StudentsId(Integer student_id, Integer university_id) {
        this.student_id = student_id;
        this.university_id = university_id;
    }

    @Override
    public String toString() {
        return "StudentsId{" + "student_id=" + student_id + ", university_id=" + university_id + '}';
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Integer university_id) {
        this.university_id = university_id;
    }
}