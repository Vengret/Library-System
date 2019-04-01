package com.project.library.DAOs;

import com.project.library.entities.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    List<BorrowedBook> findByUser_Username(String username);
    List<BorrowedBook> findByUser_UsernameOrderByDateDesc(String username);
}
