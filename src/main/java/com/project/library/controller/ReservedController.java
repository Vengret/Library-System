package com.project.library.controller;

import com.project.library.entities.Book;
import com.project.library.entities.ReservedBook;
import com.project.library.entities.User;
import com.project.library.service.entityServices.BookService;
import com.project.library.service.entityServices.ReservedBookService;
import com.project.library.service.entityServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/reserved")
public class ReservedController {

    // Autowire required services
    private ReservedBookService reservedBookService;
    private UserService userService;
    private BookService bookService;
    @Autowired
    public ReservedController(ReservedBookService theReservedBookService, UserService theUserService, BookService theBookService){
        reservedBookService = theReservedBookService;
        userService = theUserService;
        bookService = theBookService;
    }

    // Return confirmation page for reserved book
    @GetMapping("confirmation")
    public String reserveBook(Model theModel, @RequestParam("bookId") int bookId, Principal principal){
        // get user
        User user = userService.findByUsername(principal.getName());

        // get book
        Book book = bookService.findById(bookId);

        // create reserved book object
        ReservedBook reservedBook = new ReservedBook(user, book);

        // save object to database
        ReservedBook confirmation = reservedBookService.createReservation(reservedBook);

        // add attributes
        theModel.addAttribute("reservation", confirmation);

        return "reservation-confirmation";
    }

}
