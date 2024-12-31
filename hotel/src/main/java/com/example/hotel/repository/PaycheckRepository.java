package com.example.hotel.repository;

import com.example.hotel.entity.Paycheck;
import com.example.hotel.entity.PaycheckId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaycheckRepository extends JpaRepository<Paycheck, PaycheckId> {
   Optional<List<Paycheck>> findAllByStaffId(Long staffId);
}
