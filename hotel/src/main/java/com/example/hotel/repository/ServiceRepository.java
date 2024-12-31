package com.example.hotel.repository;

import com.example.hotel.entity.RequestService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<RequestService,Long> {
}
