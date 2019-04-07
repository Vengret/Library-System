package com.project.library.service.entityServices;

import com.project.library.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findByItem_ItemId(int itemId); // Allows a way to search by associated item id
    Book findById(int id);
    void setStatus(int bookId, String status);
    void updateBook(int bookId, String status, String dueDate);
}
