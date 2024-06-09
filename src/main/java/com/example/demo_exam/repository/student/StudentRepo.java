package com.example.demo_exam.repository.student;

import com.example.demo_exam.connectDB.ConnectDB;
import com.example.demo_exam.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo{
    @Override
    public List<Student> selectAllStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from  students";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setStudentId(rs.getInt("studentId"));
            student.setCode(rs.getString("studentCode"));
            student.setName(rs.getString("name"));
            student.setClassroom(rs.getString("class"));
            students.add(student);
        }
        return students;
    }
}
