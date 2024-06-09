package com.example.demo_exam.services.book;

import com.example.demo_exam.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    List<Book> selectBookAll() ;
    Book findBookById(int id);
    void updateBookQuantity(int id, int quantity);
}
