package com.project.library.service.entityServices;

import com.project.library.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findByItem_ItemId(int titleId); // Allows a way to search by associated title id
    Book findById(int id);
}
