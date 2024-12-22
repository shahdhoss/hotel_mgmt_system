package com.example.hotel.repository;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RoomAmenityId implements Serializable {
    private Long roomId;
    private String amenity;

}

