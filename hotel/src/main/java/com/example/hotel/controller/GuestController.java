package com.example.hotel.controller;

import com.example.hotel.dto.GuestDto;

import com.example.hotel.entity.GuestRepository;
import com.example.hotel.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class GuestController {
    public GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/register")
    public String getGuestRegister(Model model){
        model.addAttribute("guestDto", new GuestDto());
        return "register";
    }

    @PostMapping("/register")
    public String guestRegister(@Valid @ModelAttribute GuestDto guestDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        guestService.saveUser(guestDto);
       model.addAttribute("message", "Registration successful");
       return "home";
    }
}
