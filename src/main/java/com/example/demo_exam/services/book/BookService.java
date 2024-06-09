package com.example.demo_exam.services.book;

import com.example.demo_exam.models.Book;
import com.example.demo_exam.repository.book.BookRepo;
import com.example.demo_exam.repository.book.IBookRepo;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService {
    IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> selectBookAll() {
        try {
            return bookRepo.selectBookAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBookById(int id) {
        try {
           return bookRepo.findBookById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBookQuantity(int id, int quantity) {
        try {
            bookRepo.updateBookQuantity(id,quantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
