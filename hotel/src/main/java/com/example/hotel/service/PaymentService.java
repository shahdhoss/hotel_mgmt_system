package com.example.hotel.service;

import com.example.hotel.dto.PaymentDTO;
import com.example.hotel.entity.Payment;
import com.example.hotel.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment processPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setGuestId(paymentDTO.getGuestId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod() != null ? paymentDTO.getPaymentMethod() : "Unknown");
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        return paymentRepository.save(payment);
    }

    public PaymentDTO getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found with ID: " + paymentId));
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PaymentDTO convertToDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(payment.getId());
        paymentDTO.setGuestId(payment.getGuestId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        return paymentDTO;
    }
}
