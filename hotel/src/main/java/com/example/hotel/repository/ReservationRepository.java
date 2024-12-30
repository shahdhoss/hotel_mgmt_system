package com.example.hotel.repository;

import com.example.hotel.entity.Reservation;
import com.example.hotel.entity.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
    List<Reservation> findAllByRoomId(Long roomid);
}
