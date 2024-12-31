package com.example.hotel.service;

import com.example.hotel.dto.ServiceDto;
import com.example.hotel.entity.Guest;
import com.example.hotel.entity.RequestService;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.GuestRepository;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.repository.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void requestService(Long roomId, ServiceDto serviceDto) {
        RequestService requestService = new RequestService();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Guest loggedInGuest = guestRepository.findByEmailAddress(username)
                .orElseThrow(() -> new RuntimeException("Guest not found"));
        Long loggedInGuestId = loggedInGuest.getId();
        Optional<Room> roomOptional = roomRepository.findById(roomId);
        Optional<Guest> guestOptional = guestRepository.findById(loggedInGuestId);
        if (roomOptional.isEmpty()) {
            throw new EntityNotFoundException("Room with ID " + roomId + " not found.");
        }

        if (guestOptional.isEmpty()) {
            throw new EntityNotFoundException("Guest with ID " +loggedInGuestId+ " not found.");
        }
        Room room = roomOptional.get();
        Guest guest = guestOptional.get();
        requestService.setComment(serviceDto.getComment());
        requestService.setRequest(serviceDto.getService());
        requestService.setRoom(room);
        requestService.setGuest(guest);
        serviceRepository.save(requestService);
    }

}
