package com.project.library.DAOs;

import com.project.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByItem_ItemId(int titleId); // gives a way to search for a book based on items's id
}
