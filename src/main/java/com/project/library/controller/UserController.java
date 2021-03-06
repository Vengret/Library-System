/*
Request mapping for all pages related to users
 */

package com.project.library.controller;

import com.project.library.entities.*;
import com.project.library.service.entityServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    // Autowire required services
    private UserService userService;
    private BorrowedBookService borrowedBookService;
    private ReviewService reviewService;
    private ReservedBookService reservedBookService;
    private CheckedOutBookService checkedOutBookService;
    @Autowired UserController(UserService theUserService, BorrowedBookService theBorrowedBookService, ReviewService theReviewService, ReservedBookService theReservedBookService, CheckedOutBookService theCheckedOutBookService){
        userService = theUserService;
        borrowedBookService = theBorrowedBookService;
        reviewService = theReviewService;
        reservedBookService = theReservedBookService;
        checkedOutBookService = theCheckedOutBookService;
    }

    // Maps to an account main page
    // From here, users will be able to view and edit their profiles
    @GetMapping("/accountPage")
    public String accountPage(Model theModel, Principal principal){

        // Get the user's name using spring security's Principal
        String username = principal.getName();
        User user = userService.findByUsername(principal.getName());
        int userId = user.getUserId();

        if(user == null){
            throw new RuntimeException("Username not found");
        }

        // add the user to the model
        theModel.addAttribute("user", user);

        // Get list of borrowed books history
        List<BorrowedBook> history = borrowedBookService.findByUser_UsernameOrderByDateDesc(username);
        theModel.addAttribute("history", history);

        // We need to get which items the user has reviewed so we know to give them a link to add a review or see their review
        // Get list of user's reviews
        List<Review> reviews = reviewService.findByReviewId_User_User_id(userId);
        // get list of items from list of reviews
        List<Integer> itemIds = new ArrayList<>();
        for (Review temp : reviews){
            itemIds.add(temp.getReviewId().getItem().getItemId());
        }
        theModel.addAttribute("itemIds", itemIds);

        // Get list of reserved books
        List<ReservedBook> reservedBooks = reservedBookService.findByUser_Username(principal.getName());
        theModel.addAttribute("reserved", reservedBooks);

        // Get list of checked out books
        List<CheckedOutBook> checkedOutBooks = checkedOutBookService.findByUser_Username(principal.getName());
        theModel.addAttribute("checkedBooks", checkedOutBooks);

        return "/account";
    }
}
