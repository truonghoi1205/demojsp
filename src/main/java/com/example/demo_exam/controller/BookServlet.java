package com.example.demo_exam.controller;

import com.example.demo_exam.models.Book;
import com.example.demo_exam.services.book.BookService;
import com.example.demo_exam.services.book.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books/*")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                listBook(req,resp);
                break;
        }
    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectBookAll();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/views/listBook.jsp").forward(req,resp);
    }

}
