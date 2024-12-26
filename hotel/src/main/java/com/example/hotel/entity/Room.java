package com.example.hotel.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int pricePerNight;
    private String picture;
    private String description;
    private Boolean isRequestHousekeeping;
    private Boolean isRequestLaundry;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<RoomAmenity> roomAmenityList = new ArrayList<>();

    public Room(){}
    public Room(int pricePerNight,String picture, String description, Boolean isRequestHousekeeping, Boolean isRequestLaundry){
        setPricePerNight(pricePerNight);
        setPicture(picture);
        setDescription(description);
        setRequestHousekeeping(isRequestHousekeeping);
        setRequestLaundry(isRequestLaundry);
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getRequestHousekeeping() {
        return isRequestHousekeeping;
    }

    public Boolean getRequestLaundry() {
        return isRequestLaundry;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setRequestHousekeeping(Boolean requestHousekeeping) {
        isRequestHousekeeping = requestHousekeeping;
    }

    public void setRequestLaundry(Boolean requestLaundry) {
        isRequestLaundry = requestLaundry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
