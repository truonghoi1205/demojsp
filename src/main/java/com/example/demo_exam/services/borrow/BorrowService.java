package com.example.demo_exam.services.borrow;

import com.example.demo_exam.models.Book;
import com.example.demo_exam.models.Borrow;
import com.example.demo_exam.repository.borrow.BorrowRepo;
import com.example.demo_exam.repository.borrow.IBorrowRepo;
import com.example.demo_exam.services.book.BookService;


import java.sql.SQLException;
import java.util.List;

public class BorrowService implements IBorrowService {
   private static IBorrowRepo borrowRepo = new BorrowRepo();


    @Override
    public void insertBorrow(Borrow borrow) {
        try {
            borrowRepo.insertBorrow(borrow);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Borrow> selectAllBorrow() {
        try {
            return borrowRepo.selectAllBorrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBorrow(int id) {
        try {
            borrowRepo.deleteBorrow(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
