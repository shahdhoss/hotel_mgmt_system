package com.example.hotel.dto;

import jakarta.validation.constraints.NotNull;

public class ServiceDto {
    @NotNull
    private Long roomId;
    @NotNull
    private String service;
    private String comment;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getComment() {
        return comment;
    }

    public String getService() {
        return service;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomId() {
        return roomId;
    }
}
