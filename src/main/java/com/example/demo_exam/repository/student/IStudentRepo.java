package com.example.demo_exam.repository.student;

import com.example.demo_exam.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepo {
    List<Student> selectAllStudent() throws SQLException;
}
