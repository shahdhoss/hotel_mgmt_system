package com.example.hotel.entity;

import jakarta.persistence.Embeddable;

import java.awt.geom.RectangularShape;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ReservationId implements Serializable {
    private Long guestId;
    private Long roomId;
    private LocalDate start_date;
    private LocalDate end_date;
    public ReservationId(Long roomId, Long guestId, LocalDate start_date, LocalDate end_date){
        this.roomId=roomId;
        this.guestId=guestId;
        this.start_date=start_date;
        this.end_date=end_date;
    }
    public ReservationId() {}

    public LocalDate getEnd_date() {
        return end_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
}
