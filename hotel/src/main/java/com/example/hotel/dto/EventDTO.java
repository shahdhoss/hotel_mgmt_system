package com.example.hotel.dto;

import java.time.LocalDateTime;

public class EventDTO {
    private Long id;

    private String name;

    private String description;

    private String performer;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double price;

    private String imageURL;

    public EventDTO() {}

    public EventDTO(Long id, String name, String description, String performer, LocalDateTime startTime, LocalDateTime endTime, Double price, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.performer = performer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.imageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
