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

    public EventDTO() {}

    public EventDTO(String name, String description, String performer, LocalDateTime startTime, LocalDateTime endTime, Double price) {
        this.name = name;
        this.description = description;
        this.performer = performer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
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
}
