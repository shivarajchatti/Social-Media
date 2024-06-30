package com.shivaraj.new_website.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping("/home")//retrieve data from database
    public String homeControllerHandler(){
        return "This is home controller";
    }
   // @PostMapping //add new data into database

    //@PutMapping //update the database
    //@DeleteMapping //Delete data in database
}
