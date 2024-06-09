package com.example.demo_exam.services.borrow;

import com.example.demo_exam.models.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowService {
   void insertBorrow(Borrow borrow) ;

   List<Borrow> selectAllBorrow();

   void deleteBorrow(int id) ;
   void updateBorrow(int id, boolean status) ;
   Borrow findBorrowById(int id) ;
}
