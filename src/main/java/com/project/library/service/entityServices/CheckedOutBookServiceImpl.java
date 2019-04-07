package com.project.library.service.entityServices;

import com.project.library.DAOs.CheckedOutBookRepository;
import com.project.library.entities.CheckedOutBook;
import com.project.library.entities.ReservedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckedOutBookServiceImpl implements CheckedOutBookService {

    // autowire checked out book repository
    private CheckedOutBookRepository checkedOutBookRepository;
    @Autowired
    public CheckedOutBookServiceImpl(CheckedOutBookRepository theCheckedOutBookRepository){
        checkedOutBookRepository = theCheckedOutBookRepository;
    }

    @Override
    public List<CheckedOutBook> findByUser_Username(String username) {
        return checkedOutBookRepository.findByUser_Username(username);
    }

    @Override
    public List<CheckedOutBook> findByBook_Id(int bookId) {
        return checkedOutBookRepository.findByBook_Id(bookId);
    }

    @Override
    public CheckedOutBook createCheckedOutBook(CheckedOutBook checkedOutBook) {
        return checkedOutBookRepository.saveAndFlush(checkedOutBook);
    }

}
