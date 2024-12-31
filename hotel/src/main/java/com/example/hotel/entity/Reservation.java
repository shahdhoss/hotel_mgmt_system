package com.example.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@JsonIgnoreProperties({"room", "guest"})
@Entity
@Table(name = "reservation")
public class Reservation {
    @EmbeddedId
    private ReservationId reservationId;
    @ManyToOne
    @JoinColumn(name = "roomId", insertable = false, updatable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "guestId", insertable = false, updatable = false)
    private Guest guest;
    private PaymentMethod paymentMethod;
    private int paymentAmount;

    public ReservationId getReservationId() {
        return reservationId;
    }
    public Guest getGuest() {
        return guest;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Room getRoom() {
        return room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setReservationId(ReservationId reservationId) {
        this.reservationId = reservationId;
    }

}
