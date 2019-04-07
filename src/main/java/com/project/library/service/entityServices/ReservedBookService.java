package com.project.library.service.entityServices;

import com.project.library.entities.ReservedBook;

import java.util.List;

public interface ReservedBookService {
    List<ReservedBook> findByUser_Username(String username);
    List<ReservedBook> findByBook_Id(int bookId);
    ReservedBook createReservation(ReservedBook reservedBook);
    void deleteByBook_Id(int bookId);
}
