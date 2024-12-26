package com.example.hotel.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class PaycheckId implements Serializable{
    private Long staffId;
    private Long salary;
    private LocalDate issueDate;
}
