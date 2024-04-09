package com.example.customswaggerui.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "teachers")
public class Teacher {

    @EmbeddedId
    private TeacherID id;

    @Column(name = "teacher_name")
    private String teacher_name;

    @Column(name = "subject_id")
    private int subject_id;

    public Teacher() {
    }

    public Teacher(TeacherID id, String teacher_name, int subject_id) {
        this.id = id;
        this.teacher_name = teacher_name;
        this.subject_id = subject_id;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", teacher_name='" + teacher_name + '\'' + ", subject_id=" + subject_id + '}';
    }

    public TeacherID getId() {
        return id;
    }

    public void setId(TeacherID id) {
        this.id = id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}