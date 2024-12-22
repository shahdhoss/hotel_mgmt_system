package com.example.hotel.repository;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ReservationId implements Serializable {
    private Long guestId;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
}
