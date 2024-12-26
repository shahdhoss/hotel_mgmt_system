package com.example.hotel.repository;

import com.example.hotel.entity.Paycheck;
import com.example.hotel.entity.PaycheckId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaycheckRepository extends JpaRepository<Paycheck, PaycheckId> {
}
