package com.example.hotel.entity;

import jakarta.persistence.Embeddable;

import java.awt.geom.RectangularShape;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ReservationId implements Serializable {
    private Long guestId;
    private Long roomId;
    private LocalDate startdate;
    private LocalDate enddate;
    public ReservationId(Long roomId, Long guestId, LocalDate start_date, LocalDate end_date){
        this.roomId=roomId;
        this.guestId=guestId;
        this.startdate=start_date;
        this.enddate=end_date;
    }
    public ReservationId() {}

    public LocalDate getEnd_date() {
        return enddate;
    }

    public LocalDate getStart_date() {
        return startdate;
    }

    public void setEnd_date(LocalDate end_date) {
        this.enddate = end_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.startdate = start_date;
    }
}
