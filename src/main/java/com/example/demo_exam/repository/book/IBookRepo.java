package com.example.demo_exam.repository.book;

import com.example.demo_exam.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
    List<Book> selectBookAll() throws SQLException;
    Book findBookById(int id)throws SQLException;
    void updateBookQuantity(int id, int quantity) throws SQLException;
}
