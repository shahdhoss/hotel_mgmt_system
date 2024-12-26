package com.example.hotel.controller;

import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable Long id, Model model) {
        try {
            String pictureURL = roomService.getRoomPicture(id);
            model.addAttribute("pictureURL", pictureURL);
            return "details";
        } catch (Exception e) {
            return "home";
        }
    }
}
