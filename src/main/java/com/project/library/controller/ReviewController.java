/*
Request mappings for all pages related to reviews
TODO: Add page for users to add reviews
TODO: Add page to see reviews for a given title
 */


package com.project.library.controller;

import com.project.library.entities.*;
import com.project.library.service.entityServices.ItemService;
import com.project.library.service.entityServices.ReviewService;
import com.project.library.service.entityServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    // Autowire a ReviewService
    private ReviewService reviewService;
    private ItemService itemService;
    private UserService userService;
    @Autowired ReviewController(ReviewService theReviewService, ItemService theItemService, UserService theUserService){
        reviewService = theReviewService;
        itemService = theItemService;
        userService = theUserService;
    }

    // This is just a test page created to confirm that program is working friendly with this review object
    // TODO: delete this mapping and page when other pages are setup
    @GetMapping("testList")
    public String testListReviews(Model theModel){
        List<Review> reviews = reviewService.findAll();
        theModel.addAttribute("reviews", reviews);

        return "testReviews";
    }

    // Sends the user to a form to create a review for a title
    @GetMapping("reviewForm")
    public String reviewForm(Model theModel, @RequestParam("titleId") int titleId, @RequestParam("userId") String userId){

        // Add attributes
        theModel.addAttribute("review", new Review()); // TODO: test if this is obsolete
        theModel.addAttribute("userId", userId);
        theModel.addAttribute("titleId", titleId);
        theModel.addAttribute("reviewObject", new ReviewFormObject()); // Added to model to capture form data

        return "reviewForm";
    }

    // Saves review
    // TODO: Create new view-review page where users can view/edit their reviews at any time.
    // TODO: There should be a way to use  Jackson dependency to make this easier and better than tracking titleId and userId through so many handoffs
    @PostMapping("confirmReview")
    public String confirmReview(Model theModel, @RequestParam("titleId") int titleId, @RequestParam("userId") String userId, @ModelAttribute ReviewFormObject reviewFormObject){

        // Get user and title
        User user = userService.findByUsername(userId);
        Item title = itemService.findById(titleId);

        // Create review object
        Review theReview = new Review(new ReviewId(user, title), (float) reviewFormObject.getValue(), reviewFormObject.getContent());

        // save review to database
        reviewService.createReview(theReview);

        // add review to model
        theModel.addAttribute("review", theReview);

        return "review-confirmed";
    }

}
