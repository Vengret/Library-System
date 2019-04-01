/*
Request mappings for all pages related to titles
 */

package com.project.library.controller;

import com.project.library.entities.Item;
import com.project.library.service.entityServices.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

// ******************************************
// TODO: Title class was changed to Item. Make all comments and variable names relfect this change
// ******************************************

@Controller
@RequestMapping("/collection")
public class ItemController {

    // Autowire a TitleService
    private ItemService itemService;
    @Autowired
    public ItemController(ItemService theItemService){itemService = theItemService;}

    // Get a complete list of available titles
    @GetMapping("list")
    public String listTitles(Model theModel){

        // Get the list of available titles
        // Shuffle them so that users see a random books at the top each time instead of the same ones all the time
        List<Item> titles = itemService.findAll();
        Collections.shuffle(titles);

        // Add the list of titles to the model
        theModel.addAttribute("titles", titles);

        return "title-list";
    }

    // Allows the users to search by a title
    // Sends user back to title-list page with defined list
    @GetMapping("searchTitle")
    public String searchTitle(Model theModel, @RequestParam String titleSearch){

        // Search for titles based on the user's input
        List<Item> titleList = itemService.findByTitleContainingIgnoreCase(titleSearch);

        // Exception handling if nothing is returned
        if (titleList == null){
            throw new RuntimeException("No books found with that title");
        }

        // Add list of titles to the model
        theModel.addAttribute("titles", titleList);

        return "title-list";
    }

    // Allows users to search by an author's name
    // Sends user back to title-list page with defined list
    @GetMapping("searchAuthor")
    public String searchAuthor(Model theModel, @RequestParam String authorSearch){

        // Search for titles based on author's name
        List<Item> titleList = itemService.findByAuthorContainingIgnoreCase(authorSearch);

        // Exception handling if nothing is returned
        if (titleList == null){
            throw new RuntimeException("No books found with that title");
        }

        // Add list of titles to the model
        theModel.addAttribute("titles", titleList);

        return "title-list";
    }

    // Allows users to search by genre
    // Sends user back to title-list page with defined list
    @GetMapping("searchGenre")
    public String searchGenre(Model theModel, @RequestParam String genreSearch){

        // Search for titles based on genre
        List<Item> titleList = itemService.findByGenreContainingIgnoreCase(genreSearch);

        // Exception handling if nothing is returned
        if (titleList == null){
            throw new RuntimeException("No books found with that title");
        }

        // Add list of titles to the model
        theModel.addAttribute("titles", titleList);

        return "title-list";
    }

}
