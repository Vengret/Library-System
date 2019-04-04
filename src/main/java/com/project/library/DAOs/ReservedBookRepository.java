package com.project.library.DAOs;

import com.project.library.entities.ReservedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservedBookRepository extends JpaRepository<ReservedBook, Integer> {
    List<ReservedBook> findByUser_Username(String username);
    List<ReservedBook> findByBook_Id(int bookId);
}
