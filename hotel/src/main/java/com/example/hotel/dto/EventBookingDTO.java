package com.example.hotel.dto;

import java.time.LocalDateTime;

public class EventBookingDTO {
    private Long id;
    private Long eventId;
    private String eventName;
    private Long guestId;
    private String guestName;
    private int quantity;
    private double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime bookingDate;

    public EventBookingDTO() {}

    public EventBookingDTO(Long id, Long eventId, String eventName, Long guestId, String guestName, int quantity, double paymentAmount, String paymentMethod, String paymentStatus, LocalDateTime bookingDate) {
        this.id = id;
        this.eventId = eventId;
        this.eventName = eventName;
        this.guestId = guestId;
        this.guestName = guestName;
        this.quantity = quantity;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.bookingDate = bookingDate;
    }

    public EventBookingDTO(Long id, Long id1, String name, Long id2, String s, int quantity, LocalDateTime bookingDate) {
        this.id = id;
        this.eventId = id1;
        this.eventName = name;
        this.guestId = id2;
        this.guestName = s;
        this.quantity = quantity;
        this.bookingDate = bookingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}