package com.example.demo_exam.repository.borrow;

import com.example.demo_exam.models.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowRepo {
    void insertBorrow(Borrow borrow) throws SQLException;

    List<Borrow> selectAllBorrow() throws SQLException;

    void deleteBorrow(int id) throws SQLException;

}
