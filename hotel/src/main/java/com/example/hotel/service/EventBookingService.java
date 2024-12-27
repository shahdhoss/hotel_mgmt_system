package com.example.hotel.service;

import com.example.hotel.dto.EventBookingDTO;
import com.example.hotel.dto.EventDTO;
import com.example.hotel.dto.GuestDTO;
import com.example.hotel.dto.PaymentDTO;
import com.example.hotel.entity.Event;
import com.example.hotel.entity.EventBooking;
import com.example.hotel.entity.Guest;
import com.example.hotel.service.ResourceNotFoundException;
import com.example.hotel.repository.EventBookingRepository;
import com.example.hotel.repository.EventRepository;
import com.example.hotel.repository.GuestRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventBookingService {

    private final EventBookingRepository eventBookingRepository;
    private final EventRepository eventRepository;
    private final GuestRepository guestRepository;
    private final PaymentService paymentService;

    public EventBookingService(EventBookingRepository eventBookingRepository,
                               EventRepository eventRepository,
                               GuestRepository guestRepository,
                               PaymentService paymentService) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
        this.paymentService = paymentService;
    }

    public List<EventBookingDTO> getAllBookings() {
        return eventBookingRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EventBookingDTO getBookingById(Long id) {
        EventBooking booking = eventBookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + id));
        return convertToDTO(booking);
    }

    @Transactional
    public EventBookingDTO bookTickets(EventBookingDTO bookingDTO, PaymentDTO paymentDTO) {
        Event event = eventRepository.findById(bookingDTO.getEventId())
                .orElseThrow(() -> new IllegalArgumentException("Event not found with ID: " + bookingDTO.getEventId()));
        Guest guest = guestRepository.findById(bookingDTO.getGuestId())
                .orElseThrow(() -> new IllegalArgumentException("Guest not found with ID: " + bookingDTO.getGuestId()));

        EventBooking booking = new EventBooking(event, guest, bookingDTO.getQuantity(), LocalDateTime.now());
        EventBooking savedBooking = eventBookingRepository.save(booking);

        paymentDTO.setAmount(event.getPrice() * bookingDTO.getQuantity());
        paymentDTO.setPaymentStatus("Paid");
        paymentDTO.setPaymentDate(LocalDateTime.now());
        paymentService.processPayment(paymentDTO);

        return convertToDTO(savedBooking);
    }

    private EventBookingDTO convertToDTO(EventBooking booking) {
        EventDTO eventDTO = new EventDTO(
                booking.getEvent().getId(),
                booking.getEvent().getName(),
                booking.getEvent().getDescription(),
                booking.getEvent().getPerformer(),
                booking.getEvent().getStartTime(),
                booking.getEvent().getEndTime(),
                booking.getEvent().getPrice(),
                booking.getEvent().getImageURL()
        );

        GuestDTO guestDTO = new GuestDTO(
                booking.getGuest().getId(),
                booking.getGuest().getFirstName(),
                booking.getGuest().getLastName(),
                booking.getGuest().getEmailAddress()
        );

        return new EventBookingDTO(
                booking.getId(),
                booking.getEvent().getId(),
                booking.getEvent().getName(),
                booking.getGuest().getId(),
                guestDTO.getFirstName() + " " + guestDTO.getLastName(),
                booking.getQuantity(),
                booking.getBookingDate()
        );
    }

    public Long getGuestIdByPrincipal(Principal principal) {
        return guestRepository.findByEmailAddress(principal.getName())
                .map(Guest::getId)
                .orElseThrow(() -> new UsernameNotFoundException("Guest not found with email: " + principal.getName()));
    }

    public EventDTO getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .map(event -> new EventDTO(
                        event.getId(),
                        event.getName(),
                        event.getDescription(),
                        event.getPerformer(),
                        event.getStartTime(),
                        event.getEndTime(),
                        event.getPrice(),
                        event.getImageURL()
                ))
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));
    }
}
