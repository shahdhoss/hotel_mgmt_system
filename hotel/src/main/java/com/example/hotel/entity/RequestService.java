package com.example.hotel.entity;

import jakarta.persistence.*;

@Entity
public class RequestService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name="guest_id", referencedColumnName = "id", nullable = false)
    private Guest guest;
    private String request;
    private String comment;

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public String getComment() {
        return comment;
    }

    public String getRequest() {
        return request;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    public RequestService(){

    }
}

