/*
Request mappings for all pages related to reviews
TODO: Add page to see reviews for a given title
 */


package com.project.library.controller;

import com.project.library.entities.*;
import com.project.library.entities.FormObjects.ReviewFormObject;
import com.project.library.service.entityServices.ItemService;
import com.project.library.service.entityServices.ReviewService;
import com.project.library.service.entityServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // Sends the user to a form to create a review for a item
    @GetMapping("reviewForm")
    public String reviewForm(Model theModel, @RequestParam("itemId") int itemId, @RequestParam("userId") String userId){

        // Add attributes
        theModel.addAttribute("review", new Review()); // TODO: test if this is obsolete
        theModel.addAttribute("userId", userId);
        theModel.addAttribute("itemId", itemId);
        theModel.addAttribute("reviewObject", new ReviewFormObject()); // Added to model to capture form data

        return "reviewForm";
    }

    // Saves review
    // TODO: Create new view-review page where users can view/edit their reviews at any time.
    // TODO: There should be a way to use  Jackson dependency to make this easier and better than tracking itemId and userId through so many handoffs
    @PostMapping("confirmReview")
    public String confirmReview(Model theModel, @RequestParam("itemId") int itemId, @RequestParam("userId") String userId, @ModelAttribute ReviewFormObject reviewFormObject){

        // Get user and item
        User user = userService.findByUsername(userId);
        Item item = itemService.findById(itemId);

        // Create review object
        Review theReview = new Review(new ReviewId(user, item), (float) reviewFormObject.getValue(), reviewFormObject.getContent());

        // save review to database
        reviewService.createReview(theReview);

        // add review to model
        theModel.addAttribute("review", theReview);

        return "review-confirmed";
    }

}
