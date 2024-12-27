package com.example.hotel.controller;

import com.example.hotel.dto.EventBookingDTO;
import com.example.hotel.dto.EventDTO;
import com.example.hotel.dto.PaymentDTO;
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
    public String bookTickets(@RequestParam Long eventId,
                              @RequestParam int quantity,
                              Principal principal,
                              RedirectAttributes redirectAttributes) {

        if (principal == null) {
            redirectAttributes.addFlashAttribute("error", "You must be logged in to book tickets.");
            return "redirect:/login";
        }

        Long guestId = bookingService.getGuestIdByPrincipal(principal);

        EventBookingDTO bookingDTO = new EventBookingDTO();
        bookingDTO.setEventId(eventId);
        bookingDTO.setGuestId(guestId);
        bookingDTO.setQuantity(quantity);

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setGuestId(guestId);
        paymentDTO.setAmount(0.0);
        paymentDTO.setPaymentMethod("Credit Card");
        paymentDTO.setPaymentStatus("Paid");

        bookingService.bookTickets(bookingDTO, paymentDTO);

        redirectAttributes.addFlashAttribute("message", "Booking successful!");
        return "confirmation";
    }

}
