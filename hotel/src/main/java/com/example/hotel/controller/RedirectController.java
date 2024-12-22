package com.example.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RedirectController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/home")
    public String index(){
        return "home";
    }

    @GetMapping("/rooms")
    public String rooms(){
        return "rooms";
    }

    @GetMapping("/gallery")
    public String gallery(){
        return "gallery";
    }

    @GetMapping("/amenities")
    public String amenities(){
        return "amenities";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
