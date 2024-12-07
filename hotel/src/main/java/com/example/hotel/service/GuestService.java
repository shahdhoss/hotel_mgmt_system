package com.example.hotel.service;
import com.example.hotel.entity.Guest;
import com.example.hotel.entity.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository){
        this.guestRepository=guestRepository;
    }

    public void saveGuest() {
        Guest guest = new Guest("shahd@gmail.com", "shahd", "hossam", "shahdd");
        guestRepository.save(guest);  // This calls the repository to persist the entity
    }
    public List<Guest> getGuests(){
        return guestRepository.findAll();
    }
}
