package com.example.hotel.controller;

import com.example.hotel.dto.RoomBookingDTO;
import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/rooms")
    public String getRooms(Model model){
        List<Room> roomsList=roomService.viewRooms();
        model.addAttribute("rooms",roomsList);
        return "rooms";
    }
    @GetMapping("/details/{roomid}")
    public String getDetails(@PathVariable Long roomid, Model model, Authentication authentication) {
        try {
            String pictureURL = roomService.getRoomPicture(roomid);
            model.addAttribute("pictureURL", pictureURL);
            return "details";
        } catch (Exception e) {
            return "home";
        }
    }
    @GetMapping("/roombooking/{roomid}")
    public String showBookingForm(@PathVariable Long roomid, Model model) {
        Room room = roomService.getRoom(roomid);
        model.addAttribute("roomDTO", room);
        model.addAttribute("roomId", roomid);
        model.addAttribute("roomBookingdto", new RoomBookingDTO());
        return "roombooking";
    }
    @PostMapping("/roombooking/{roomid}")
    public String getBookingData(@PathVariable Long roomid, @Valid @ModelAttribute("roomBookingdto") RoomBookingDTO roomBookingDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "roombooking";
        }
        return roomService.bookRoom(roomBookingDTO, roomid, roomBookingDTO.getStartdate(), roomBookingDTO.getEnddate());
    }
}
