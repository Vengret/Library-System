/*
Creates methods for BorrowedBook queries
 */

package com.project.library.service.entityServices;

import com.project.library.DAOs.BorrowedBookRepository;
import com.project.library.entities.BorrowedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService{

    // Autowire BorrowedBookRepo
    private BorrowedBookRepository borrowedBookRepository;
    @Autowired
    public BorrowedBookServiceImpl(BorrowedBookRepository theBorrowedBookRepository){borrowedBookRepository = theBorrowedBookRepository;}

    // Find list of borrowed books base on user
    @Override
    public List<BorrowedBook> findByUser_UsernameOrderByDateDesc(String username) {
        List<BorrowedBook> borrowedBooks = borrowedBookRepository.findByUser_UsernameOrderByDateDesc(username);
        return borrowedBooks;
    }

    @Override
    @Transactional
    public BorrowedBook createBorrowedBook(BorrowedBook borrowedBook) {
        return borrowedBookRepository.saveAndFlush(borrowedBook);
    }
}
