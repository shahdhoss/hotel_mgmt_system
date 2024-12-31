package com.example.hotel.controller;

import com.example.hotel.entity.Paycheck;
import com.example.hotel.entity.Reservation;
import com.example.hotel.entity.Room;
import com.example.hotel.entity.Staff;
import com.example.hotel.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;
    @GetMapping("/showreservations")
    public List<Reservation> reservationsInfo(){
        return staffService.showReservations();
    }
    @GetMapping("/availablerooms")
    public List<Room> availableRooms(){
        return staffService.checkAvailableRooms();
    }
    @GetMapping("/{id}/status")
    public Staff viewEmploymentStatus(@PathVariable Long id) {
        return staffService.viewEmploymentStatus(id);
    }
    @GetMapping("/{id}/paychecks")
    public List<Paycheck> viewStaffPaychecks(@PathVariable Long id){
        return staffService.viewPaychecks(id);
    }
}
