package com.example.hotel.service;

import com.example.hotel.entity.*;
import com.example.hotel.repository.PaycheckRepository;
import com.example.hotel.repository.ReservationRepository;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private PaycheckRepository paycheckRepository;
    public List<Reservation> showReservations(){
        return reservationRepository.findAll();
    }
    public List<Room> checkAvailableRooms() {
        List<Room> allRooms = roomRepository.findAll();
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : allRooms){
            List<Reservation> reservations = reservationRepository.findByRoomId(room.getId());
            boolean isRoomAvailable = reservations.stream()
                    .noneMatch(reservation -> reservation.getReservationId().getEnd_date() == null ||
                            reservation.getReservationId().getEnd_date().isAfter(LocalDate.now()));
            if (isRoomAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    public Staff viewEmploymentStatus(Long id){
        Optional<Staff> staffOptional =  staffRepository.findById(id);
        if(staffOptional.isPresent()){
            Staff staff = staffOptional.get();
            return staff;
        }
        return null;
    }
    public List<Paycheck> viewPaychecks(Long staffId) {
        Optional<List<Paycheck>> paycheckOptional = paycheckRepository.findAllByStaffId(staffId);
        if (paycheckOptional.isPresent()) {
                return paycheckOptional.get();
        }
        return null;
    }

}
