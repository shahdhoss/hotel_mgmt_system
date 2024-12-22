package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest,Long> {
    Optional<Guest> findByEmailAddress(String emailAddress);
}

