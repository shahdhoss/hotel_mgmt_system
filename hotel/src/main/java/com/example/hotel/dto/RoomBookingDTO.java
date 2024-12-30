package com.example.hotel.dto;

import com.example.hotel.entity.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RoomBookingDTO {
    @NotNull(message = "Please specify a check in date")
    private LocalDate startdate;
    @NotNull(message = "Please specify a check out date")
    private LocalDate enddate;
    @NotNull(message = "Please choose a payment method")
    private PaymentMethod paymentMethod;

    public LocalDate getEnddate() {
        return enddate;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
}
