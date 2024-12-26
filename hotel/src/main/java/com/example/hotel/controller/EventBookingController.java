package com.example.hotel.controller;

import com.example.hotel.dto.EventBookingDTO;
import com.example.hotel.dto.EventDTO;
import com.example.hotel.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/bookings")
public class EventBookingController {

    private final EventBookingService bookingService;

    public EventBookingController(EventBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{eventId}")
    public String viewEventBookingPage(@PathVariable Long eventId, Model model) {
        EventDTO event = bookingService.getEventById(eventId);
        model.addAttribute("event", event);
        return "booking";
    }

    @PostMapping
    public String bookTickets(@RequestParam Long eventId, @RequestParam int quantity, Principal principal, RedirectAttributes redirectAttributes) {
        Long guestId = bookingService.getGuestIdByPrincipal(principal);

        EventBookingDTO bookingDTO = new EventBookingDTO();
        bookingDTO.setEventId(eventId);
        bookingDTO.setGuestId(guestId);
        bookingDTO.setQuantity(quantity);

        bookingService.bookTickets(bookingDTO);

        redirectAttributes.addAttribute("eventId", bookingDTO.getEventId());
        return "confirmation";

    }
}
