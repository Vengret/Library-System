package com.project.library.service.entityServices;

import com.project.library.entities.BorrowedBook;

import java.util.List;

public interface BorrowedBookService {
    List<BorrowedBook> findByUser_UsernameOrderByDateDesc(String username);
    BorrowedBook createBorrowedBook(BorrowedBook borrowedBook);
}
