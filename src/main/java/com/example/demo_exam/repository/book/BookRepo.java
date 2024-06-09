package com.example.demo_exam.repository.book;

import com.example.demo_exam.connectDB.ConnectDB;
import com.example.demo_exam.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {
    @Override
    public List<Book> selectBookAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from Books";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getInt("bookId"));
            book.setCode(rs.getString("bookCode"));
            book.setName(rs.getString("bookName"));
            book.setAuthor(rs.getString("author"));
            book.setDescription(rs.getString("description"));
            book.setQuantity(rs.getInt("quantity"));
            books.add(book);
        }
        return books;

    }

    @Override
    public Book findBookById(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from Books WHERE bookId = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getInt("bookId"));
            book.setCode(rs.getString("bookCode"));
            book.setName(rs.getString("bookName"));
            book.setAuthor(rs.getString("author"));
            book.setDescription(rs.getString("description"));
            book.setQuantity(rs.getInt("quantity"));
            return book;
        }
        return null;
    }

    public void updateBookQuantity(int id, int quantity) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update Books set quantity = ? where bookId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
