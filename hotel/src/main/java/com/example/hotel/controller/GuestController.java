package com.example.hotel.controller;

import com.example.hotel.entity.Guest;
import com.example.hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {
    public final GuestService guestService;

    @Autowired // Constructor injection, very important step
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }
    @GetMapping
    public List<Guest> saveData(){
        guestService.saveGuest();
        return guestService.getGuests();
    }
}
