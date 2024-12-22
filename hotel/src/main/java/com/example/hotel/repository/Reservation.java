package com.example.hotel.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @EmbeddedId
    private ReservationId reservationId;
    @ManyToOne
    @MapsId("guestId")
    private Guest guest;

    @ManyToOne
    @MapsId("roomId")
    private Room room;
    private PaymentMethod paymentMethod;
    private Long paymentAmount;

    public ReservationId getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Long getPaymentAmount() {
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

    public void setPaymentAmount(Long paymentAmount) {
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
