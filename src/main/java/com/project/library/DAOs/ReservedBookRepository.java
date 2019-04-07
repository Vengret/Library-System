package com.project.library.DAOs;

import com.project.library.entities.ReservedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservedBookRepository extends JpaRepository<ReservedBook, Integer> {
    List<ReservedBook> findByUser_Username(String username);
    List<ReservedBook> findByBook_Id(int bookId);

    // method to remove book from reserved list
    @Transactional
    void deleteByBook_Id(int bookId);
}
