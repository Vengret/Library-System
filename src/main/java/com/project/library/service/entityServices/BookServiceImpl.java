/*
Creates methods for Book queries
 */

package com.project.library.service.entityServices;

import com.project.library.DAOs.BookRepository;
import com.project.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Book findById(int id){
        // Search for book
        Optional<Book> result = bookRepository.findById(id);

        // In case the book isn't found
        Book theBook = null;
        if(result.isPresent()){
            theBook = result.get();
        }
        else {
            throw new RuntimeException("Did not find the book");
        }

        return theBook;
    }

    @Override
    @Transactional
    public void setStatus(int bookId, String status) {
        bookRepository.updateStatus(bookId, status);
    }

    @Override
    public void updateBook(int bookId, String status, String dueDate, String condition) {
        bookRepository.updateBook(bookId, status, dueDate, condition);
    }


}
