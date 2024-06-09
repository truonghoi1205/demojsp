package com.example.demo_exam.services.student;

import com.example.demo_exam.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudent();
}
