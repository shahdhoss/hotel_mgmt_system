package com.example.hotel.service;

import com.example.hotel.dto.RoomBookingDTO;
import com.example.hotel.entity.Guest;
import com.example.hotel.entity.Reservation;
import com.example.hotel.entity.ReservationId;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.GuestRepository;
import com.example.hotel.repository.ReservationRepository;
import com.example.hotel.repository.RoomRepository;
import org.apache.el.parser.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private GuestRepository guestRepository;
    public List<Room> viewRooms(){
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }
    public String getRoomPicture(Long id){
        Optional<Room> optionalRoom= roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            Room room=optionalRoom.get();
            return room.getPicture();
        }

        throw new IllegalArgumentException("No picture found for room ID: " + id);
    }
    public Room getRoom(Long id){
        Optional<Room> roomOptional = roomRepository.findById(id);
        if(roomOptional.isPresent()){
            Room room = roomOptional.get();
            return room;
        }
        throw new IllegalArgumentException("No room with id: " + id);
    }

    public String bookRoom(RoomBookingDTO roomBookingDTO, Long roomid, LocalDate startdate, LocalDate enddate){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Guest loggedInGuest = guestRepository.findByEmailAddress(username)
                .orElseThrow(() -> new RuntimeException("Guest not found"));
        Long loggedInGuestId = loggedInGuest.getId();
        Reservation reservation = new Reservation();
        ReservationId id = new ReservationId(roomid, loggedInGuestId,startdate,enddate);
        reservation.setReservationId(id);
        reservation.setPaymentMethod(roomBookingDTO.getPaymentMethod());
        Room room = getRoom(roomid);
        reservation.setPaymentAmount(room.getPricePerNight());
        reservationRepository.save(reservation);
        return "home";
    }
}
