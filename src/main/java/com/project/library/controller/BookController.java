/*
Request mappings for pages related to books
 */

package com.project.library.controller;

import com.project.library.entities.Book;
import com.project.library.service.entityServices.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    // Autowire a BookService
    private BookService bookService;
    @Autowired
    public BookController(BookService theBookService){bookService = theBookService;}

    // Return a list of books based on TitleId
    @GetMapping("/list")
    public String getBooks(Model theModel, @RequestParam("titleId") int titleId){

        // Retrieve list of books
        List<Book> bookList = bookService.findByItem_ItemId(titleId);

        if (bookList == null){
            throw new RuntimeException("No books for this title on record");
        }

        // Add the list of books to the model under the name books
        theModel.addAttribute("books", bookList);

        return "book-list";
    }
}
