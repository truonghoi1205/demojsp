package com.example.demo_exam.controller;

import com.example.demo_exam.models.Book;
import com.example.demo_exam.models.Borrow;
import com.example.demo_exam.models.Student;
import com.example.demo_exam.services.book.BookService;
import com.example.demo_exam.services.book.IBookService;
import com.example.demo_exam.services.borrow.BorrowService;
import com.example.demo_exam.services.borrow.IBorrowService;
import com.example.demo_exam.services.student.IStudentService;
import com.example.demo_exam.services.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet(name = "BorrowServlet", urlPatterns = "/borrows/*")
public class BorrowServlet extends HttpServlet {
    IBookService bookService = new BookService();
    IBorrowService borrowService = new BorrowService();
    IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                showFormCreateBorrow(req, resp);
                break;
            case "/list":
                showListBorrow(req, resp);
                break;
        }
    }

    private void showFormCreateBorrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.findBookById(bookId);
        List<Student> students = studentService.selectAllStudent();
        if (book.getQuantity() <= 0) {
            req.setAttribute("errorMessage", "Hết sách rồi ấy ơi, mượn cuốn khác đi.");
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("students", students);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/views/createBorrow.jsp").forward(req, resp);
    }

    private void showListBorrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Borrow> borrows = borrowService.selectAllBorrow();
        req.setAttribute("borrows", borrows);
        req.getRequestDispatcher("/views/listBorrow.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertBorrow(req, resp);
                break;
            case "/delete":
                deleteBorrow(req, resp);
                break;
        }
    }

    private void insertBorrow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("borrowCode");
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        Date borrowDate = new Date(System.currentTimeMillis());
        Date returnDate = Date.valueOf(req.getParameter("returnDate"));
        Borrow borrow = new Borrow();
        borrow.setCode(code);
        Book book = bookService.findBookById(bookId);
        borrow.setBookId(bookId);
        borrow.setStudentId(studentId);
        borrow.setStatus(true);
        borrow.setBorrowDay(borrowDate);
        borrow.setReturnDay(returnDate);
        borrowService.insertBorrow(borrow);
        bookService.updateBookQuantity(bookId, book.getQuantity() - 1);
        resp.sendRedirect("/books/list");
    }

    private void deleteBorrow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        Book book = bookService.findBookById(bookId);
        bookService.updateBookQuantity(bookId, book.getQuantity() + 1);
        borrowService.deleteBorrow(id);
        List<Borrow> borrows = borrowService.selectAllBorrow();
        req.setAttribute("borrows", borrows);
        resp.sendRedirect("/borrows/list");
    }

}
