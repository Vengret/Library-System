package com.project.library.DAOs;

import com.project.library.entities.CheckedOutBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CheckedOutBookRepository  extends JpaRepository<CheckedOutBook, Integer> {
    List<CheckedOutBook> findByUser_Username(String username);
    List<CheckedOutBook> findByBook_Id(int bookId);

    // method to remove checked out book
    @Transactional
    void deleteByBook_Id(int bookId);
}
