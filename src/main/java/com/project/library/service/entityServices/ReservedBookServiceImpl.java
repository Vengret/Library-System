package com.project.library.service.entityServices;

import com.project.library.DAOs.ReservedBookRepository;
import com.project.library.entities.ReservedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedBookServiceImpl implements ReservedBookService{

    // autowire reserved book repository
    private ReservedBookRepository reservedBookRepository;
    @Autowired
    public ReservedBookServiceImpl(ReservedBookRepository theReservedBookRepo){reservedBookRepository = theReservedBookRepo;}


    @Override
    public List<ReservedBook> findByUser_Username(String username) {
        return reservedBookRepository.findByUser_Username(username);
    }

    @Override
    public List<ReservedBook> findByBook_Id(int bookId) {
        return reservedBookRepository.findByBook_Id(bookId);
    }

    @Override
    public ReservedBook createReservation(ReservedBook reservedBook) {
        return reservedBookRepository.save(reservedBook);
    }

}
