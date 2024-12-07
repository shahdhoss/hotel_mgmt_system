package com.example.hotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paycheck")
public class Paycheck {
    @EmbeddedId
    PaycheckId paycheckId;

    @ManyToOne
    @MapsId("staffId")
    private Staff staff;

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setPaycheckId(PaycheckId paycheckId) {
        this.paycheckId = paycheckId;
    }

    public PaycheckId getPaycheckId() {
        return paycheckId;
    }
}
