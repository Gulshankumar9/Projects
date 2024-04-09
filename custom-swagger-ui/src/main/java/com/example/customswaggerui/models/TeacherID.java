package com.example.customswaggerui.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TeacherID implements Serializable {

    @Column(name = "teacher_id")
    private Integer teacher_id;
    @Column(name = "university_id")
    private Integer university_id;

    public TeacherID() {
    }

    public TeacherID(Integer teacher_id, Integer university_id) {
        this.teacher_id = teacher_id;
        this.university_id = university_id;
    }

    @Override
    public String toString() {
        return "TeacherID{" + "teacher_id=" + teacher_id + ", university_id=" + university_id + '}';
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Integer university_id) {
        this.university_id = university_id;
    }
}