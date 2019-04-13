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

@Controller
@RequestMapping("/collection")
public class ItemController {

    // Autowire a ItemService
    private ItemService itemService;
    @Autowired
    public ItemController(ItemService theItemService){itemService = theItemService;}

    // Get a complete list of available items
    @GetMapping("list")
    public String listItems(Model theModel){

        // Get the list of available items
        // Shuffle them so that users see a random books at the top each time instead of the same ones all the time
        List<Item> items = itemService.findAll();
        Collections.shuffle(items);

        // Add the list of items to the model
        theModel.addAttribute("items", items);

        return "item-list";
    }

    // Allows the users to search by a item
    // Sends user back to item-list page with defined list
    @GetMapping("searchTitle")
    public String searchTitle(Model theModel, @RequestParam String titleSearch){

        // Search for items based on the user's input
        List<Item> itemList = itemService.findByTitleContainingIgnoreCase(titleSearch);

        // Exception handling if nothing is returned
        if (itemList == null){
            throw new RuntimeException("No books found with that title");
        }

        // Add list of titles to the model
        theModel.addAttribute("items", itemList);

        return "item-list";
    }

    // Allows users to search by an author's name
    // Sends user back to title-list page with defined list
    @GetMapping("searchAuthor")
    public String searchAuthor(Model theModel, @RequestParam String authorSearch){

        // Search for items based on author's name
        List<Item> itemList = itemService.findByAuthorContainingIgnoreCase(authorSearch);

        // Exception handling if nothing is returned
        if (itemList == null){
            throw new RuntimeException("No books found with that author");
        }

        // Add list of items to the model
        theModel.addAttribute("items", itemList);

        return "item-list";
    }

    // Allows users to search by genre
    // Sends user back to item-list page with defined list
    @GetMapping("searchGenre")
    public String searchGenre(Model theModel, @RequestParam String genreSearch){

        // Search for items based on genre
        List<Item> itemList = itemService.findByGenreContainingIgnoreCase(genreSearch);

        // Exception handling if nothing is returned
        if (itemList == null){
            throw new RuntimeException("No books found with that genre");
        }

        // Add list of items to the model
        theModel.addAttribute("items", itemList);

        return "item-list";
    }

    // Allow user to search by any field
    @GetMapping("searchAny")
    public String searchAny(Model theModel, @RequestParam String searchVal){

        // Search for item based on string
        List<Item> itemList = itemService.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrGenreContainingIgnoreCase(searchVal, searchVal, searchVal);

        // Exception handling if nothing is returned
        if (itemList == null){
            throw new RuntimeException("No books found with that genre");
        }

        // Add list of items to the model
        theModel.addAttribute("items", itemList);

        return "item-list";
    }

}
