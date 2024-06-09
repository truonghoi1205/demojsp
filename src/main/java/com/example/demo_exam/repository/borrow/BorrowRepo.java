package com.example.demo_exam.repository.borrow;

import com.example.demo_exam.connectDB.ConnectDB;
import com.example.demo_exam.models.Book;
import com.example.demo_exam.models.Borrow;
import com.example.demo_exam.models.Student;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepo implements IBorrowRepo {

    @Override
    public List<Borrow> selectAllBorrow() throws SQLException {
        List<Borrow> borrows = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select br.borrowId, br.borrowCode, b.bookId , b.bookName, b.author , s.name as studentName, s.class as classroom, br.borrowDate, br.returnDate " +
                "from books b " +
                "join borrows br " +
                "on b.bookId = br.bookId " +
                "join students s " +
                "on br.studentId = s.studentId " +
                "where status = true;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Borrow borrow = new Borrow();
            borrow.setId(rs.getInt("borrowId"));
            borrow.setCode(rs.getString("borrowCode"));
            borrow.setBorrowDay(rs.getDate("borrowDate"));
            borrow.setReturnDay(rs.getDate("returnDate"));
            Book book = new Book();
            book.setBookId(rs.getInt("bookId"));
            book.setName(rs.getString("bookName"));
            book.setAuthor(rs.getString("author"));
            Student student = new Student();
            student.setName(rs.getString("studentName"));
            student.setClassroom(rs.getString("classroom"));

            borrow.setBook(book);
            borrow.setStudent(student);
            borrows.add(borrow);
        }
        return borrows;
    }

    @Override
    public void insertBorrow(Borrow borrow) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into borrows(borrowCode,bookId,studentId,status,borrowDate,returnDate) value(?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, borrow.getCode());
        ps.setInt(2, borrow.getBookId());
        ps.setInt(3, borrow.getStudentId());
        ps.setBoolean(4, borrow.isStatus());
        ps.setDate(5, borrow.getBorrowDay());
        ps.setDate(6, borrow.getReturnDay());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void deleteBorrow(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from borrows where borrowId = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        connection.close();
    }



}
