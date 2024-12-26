package com.example.hotel.repository;

import com.example.hotel.entity.RoomAmenity;
import com.example.hotel.entity.RoomAmenityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAmenityRepository extends JpaRepository<RoomAmenity, RoomAmenityId> {
}
