package com.example.hotel.dto;

import java.time.LocalDateTime;

public class PaymentDTO {
    private Long guestId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime paymentDate;

    public PaymentDTO() {}

    public PaymentDTO(Long guestId, double amount, String paymentMethod, String paymentStatus, LocalDateTime paymentDate) {
        this.guestId = guestId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setId(Long id) {
        this.guestId = id;
    }
}
