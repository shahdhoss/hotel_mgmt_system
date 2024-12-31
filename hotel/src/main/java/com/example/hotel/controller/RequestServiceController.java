package com.example.hotel.controller;

import com.example.hotel.dto.GuestRegisterDto;
import com.example.hotel.dto.RoomBookingDTO;
import com.example.hotel.dto.ServiceDto;
import com.example.hotel.entity.RequestService;
import com.example.hotel.service.RequestServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestServiceController {
    @Autowired
    private RequestServiceService requestServiceService;
    @GetMapping("/request")
    public String getRequest(Model model) {
        model.addAttribute("serviceDTO", new ServiceDto());
        return "requestservice";
    }

    @PostMapping("/request")
    public String postRequest(@Valid @ModelAttribute("serviceDTO") ServiceDto serviceDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "requestservice";
        }
        requestServiceService.requestService(serviceDto.getRoomId(), serviceDto);
        return "redirect:/home";
    }
}
