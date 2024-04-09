package com.example.customswaggerui;

import com.example.customswaggerui.models.Teacher;
import com.example.customswaggerui.models.TeacherID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, TeacherID> {

}