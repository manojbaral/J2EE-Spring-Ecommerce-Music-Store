package com.manoj.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Manoj Baral on 3/11/2017.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    //Handle login controller
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
        required = false) String logout, Model model) {
        if (error!=null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout!=null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";

    }

    //about page
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
