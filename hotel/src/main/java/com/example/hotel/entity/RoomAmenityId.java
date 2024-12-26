package com.example.hotel.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RoomAmenityId implements Serializable {
    private Long roomId;
    private String amenity;

}

