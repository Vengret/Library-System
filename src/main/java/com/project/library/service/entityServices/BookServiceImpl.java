/*
Creates methods for Book queries
 */

package com.project.library.service.entityServices;

import com.project.library.DAOs.BookRepository;
import com.project.library.entities.Book;
import com.project.library.entities.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    // Autowire a BookRepository
    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository theBookRepository){bookRepository = theBookRepository;}

    // Search for books based on associated itemId
    @Override
    public List<Book> findByItem_ItemId(int itemId) {
        return bookRepository.findByItem_ItemId(itemId);
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
    @Transactional
    public void updateBook(int bookId, String status, String dueDate) {
        bookRepository.updateBook(bookId, status, dueDate);
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBookById(int bookId) {
        bookRepository.deleteBookById(bookId);
    }


}
