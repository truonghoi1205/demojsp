package com.example.demo_exam.services.student;

import com.example.demo_exam.models.Student;
import com.example.demo_exam.repository.student.IStudentRepo;
import com.example.demo_exam.repository.student.StudentRepo;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepo studentRepo = new StudentRepo();

    @Override
    public List<Student> selectAllStudent() {
        try {
            return studentRepo.selectAllStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
