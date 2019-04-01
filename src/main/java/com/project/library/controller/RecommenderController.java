package com.project.library.controller;

import com.project.library.entities.Item;
import com.project.library.entities.User;
import com.project.library.service.entityServices.UserService;
import com.project.library.service.recommender.RecommenderService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/recommended")
public class RecommenderController {

    // autowire required services
    private RecommenderService recommenderService;
    private UserService userService;
    @Autowired
    public RecommenderController(RecommenderService theRecommenderService, UserService theUserService){
        recommenderService = theRecommenderService;
        userService = theUserService;
    }


    // mapping to return list of recommended books
    @GetMapping("recommendedBooks")
    public String getRecommendedBooks(Model theModel, Principal principal) throws TasteException {

        // Get the userId using spring security's Principal
        User user = userService.findByUsername(principal.getName());
        int userId = user.getUserId();

        // get the list of recommended books
        List<Item> items = recommenderService.getRecommendedBooks(userId);

        // add attribute
        theModel.addAttribute("recommendedBooks", items);

        return "recommended-books";
    }

}
