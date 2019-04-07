/*
Request mappings for employee related pages
 */

package com.project.library.controller;

import com.project.library.entities.Book;
import com.project.library.entities.BorrowedBook;
import com.project.library.entities.CheckedOutBook;
import com.project.library.entities.User;
import com.project.library.service.entityServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private BookService bookService;
    private CheckedOutBookService checkedOutBookService;
    private UserService userService;
    private ReservedBookService reservedBookService;
    private ItemService itemService;
    private BorrowedBookService borrowedBookService;
    @Autowired
    public EmployeeController(BookService theBookService, CheckedOutBookService theCheckedOutBookService, UserService theUserService, ReservedBookService theReservedBookService, ItemService theItemService, BorrowedBookService theBorrowedBookService){
        bookService = theBookService;
        checkedOutBookService = theCheckedOutBookService;
        userService = theUserService;
        reservedBookService = theReservedBookService;
        itemService = theItemService;
        borrowedBookService = theBorrowedBookService;
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
    public String checkOut(Model theModel, @ModelAttribute("bookId") int bookId, @ModelAttribute("userId") int userId){

        // if form passed in
        if(bookId != 0) {
            // create checked out object
            CheckedOutBook checkedOutBook = new CheckedOutBook(userService.findById(userId), bookService.findById(bookId));

            // add entry to checked out book table
            checkedOutBookService.createCheckedOutBook(checkedOutBook);

            // create due date
            int noOfDays = 7; // how long users can rent a book. change this variable to change terms
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy"); // how to format date
            String dueDate = dateFormat.format(new Date());

            // update book status and due date
            bookService.updateBook(bookId, "Checked Out", dueDate);

            // remove from reserved if reserved
            reservedBookService.deleteByBook_Id(bookId);

            // create borrowed book item
            BorrowedBook borrowedBook = new BorrowedBook(userService.findById(userId), itemService.findById(bookService.findById(bookId).getId()), dueDate);

            // add borrowed book to table
            borrowedBookService.createBorrowedBook(borrowedBook);

            // add attributes for the form
            theModel.addAttribute("userId", userId); // return user Id so you don't have to scan user id every time
            theModel.addAttribute("bookId", Integer.class);
        }
        else {
            theModel.addAttribute("userId", "User ID");
            theModel.addAttribute("bookId", Integer.class);
        }

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
