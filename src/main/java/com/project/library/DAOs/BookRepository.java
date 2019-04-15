package com.project.library.DAOs;

import com.project.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByItem_ItemId(int itemId); // gives a way to search for a book based on items's id

    // Method for updating the status of a book
    @Modifying
    @Query("UPDATE Book b SET b.status = :status WHERE b.id = :bookId")
    int updateStatus(@Param("bookId") int bookId, @Param("status") String status);

    // Method for updating all book fields
    // ItemId should never change, so isn't included here
    @Modifying
    @Query("UPDATE Book b SET b.status = :status, b.due_date = :due_date WHERE b.id = :bookId")
    int updateBook(@Param("bookId") int bookId, @Param("status") String status, @Param("due_date") String due_date);

    // method to remove book from inventory
    @Transactional
    void deleteBookById(int bookId);

}
