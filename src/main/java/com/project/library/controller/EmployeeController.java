/*
Request mappings for employee related pages
 */

package com.project.library.controller;

import com.project.library.service.entityServices.BookService;
import com.project.library.service.entityServices.CheckedOutBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private BookService bookService;
    private CheckedOutBookService checkedOutBookService;
    @Autowired
    public EmployeeController(BookService theBookService, CheckedOutBookService theCheckedOutBookService){
        bookService = theBookService;
        checkedOutBookService = theCheckedOutBookService;
    }

    @RequestMapping("/checkIn")
    public String checkIn(Model theModel, @ModelAttribute("bookId") int bookId){

        // if form passed in
        if(bookId != 0) {
            // remove book from checked out book table
            checkedOutBookService.deleteByBook_Id(bookId);
            // update book status
            bookService.setStatus(bookId, "Available");
        }

        // add integer for book id used in the form
        theModel.addAttribute("bookId", Integer.class);

        return "check-in";
    }

    @RequestMapping("/checkOut")
    public String checkOut(){

        // if form passed in

            // add entry to checked out book table

            // update book status and due date

        return "check-out";
    }

    @RequestMapping("addItem")
    public String addItem(){

        // if form passed in

            // create Item

            // save item

        return "addItem";
    }

    @RequestMapping("/addBook")
    public String addBooks(){

        // if form passed in

            // create Book

            // save book

        return "addBooks";
    }

    @RequestMapping("removeBook")
    public String removeBooks(){

        // if form passed in

            // Remove book

        return "removeBooks";
    }

}
