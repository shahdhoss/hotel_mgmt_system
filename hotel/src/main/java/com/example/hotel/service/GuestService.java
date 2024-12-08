package com.example.hotel.service;

import com.example.hotel.dto.GuestDto;
import com.example.hotel.dto.UserDto;
import com.example.hotel.entity.Guest;
import com.example.hotel.entity.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService implements UserService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository){
        this.guestRepository=guestRepository;
    }

    public void saveUser(UserDto userDto) {
        if (userDto instanceof GuestDto guestDto) {
            Guest guest = new Guest();
            guest.setFirstName(guestDto.getFirstName());
            guest.setLastName(guestDto.getLastName());
            guest.setEmailAddress(guestDto.getEmailAddress());
            guest.setPassword(guestDto.getPassword());
            guestRepository.save(guest);
        }
    }

}
