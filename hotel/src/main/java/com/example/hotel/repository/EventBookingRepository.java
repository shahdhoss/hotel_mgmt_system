package com.example.hotel.repository;

import com.example.hotel.entity.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventBookingRepository extends JpaRepository<EventBooking,Long> {
}

