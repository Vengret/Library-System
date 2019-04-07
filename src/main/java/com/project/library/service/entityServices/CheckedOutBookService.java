package com.project.library.service.entityServices;

import com.project.library.entities.CheckedOutBook;

import java.util.List;

public interface CheckedOutBookService {
    List<CheckedOutBook> findByUser_Username(String username);
    List<CheckedOutBook> findByBook_Id(int bookId);
    CheckedOutBook createCheckedOutBook(CheckedOutBook checkedOutBook);
    void deleteByBook_Id(int bookId);
}
