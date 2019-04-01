/*
General request mappings will be directed from here
TODO: add mappings for error pages
 */

package com.project.library.controller;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class AppController {

    @RequestMapping("/")
    public String welcome(){
        return "homepage.html";
    }

    //Login form
    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login.html";
    }

}
