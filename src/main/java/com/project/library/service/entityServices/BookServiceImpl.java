/*
Creates methods for Book queries
 */

package com.project.library.service.entityServices;

import com.project.library.DAOs.BookRepository;
import com.project.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    // Autowire a BookRepository
    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository theBookRepository){bookRepository = theBookRepository;}

    // Search for books based on associated itemId
    // TODO: title class was changed to item class. update the variable names
    @Override
    public List<Book> findByItem_ItemId(int titleId) {
        return bookRepository.findByItem_ItemId(titleId);
    }




}
