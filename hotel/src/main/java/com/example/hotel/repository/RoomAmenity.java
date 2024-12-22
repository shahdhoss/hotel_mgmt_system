package com.example.hotel.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "room_amenity")
public class RoomAmenity {
    @EmbeddedId
    private RoomAmenityId roomAmenityId;

    @ManyToOne
    @MapsId("roomId")
    private Room room;

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setRoomAmenityId(RoomAmenityId roomAmenityId) {
        this.roomAmenityId = roomAmenityId;
    }

    public Room getRoom() {
        return room;
    }

    public RoomAmenityId getRoomAmenityId() {
        return roomAmenityId;
    }
}
