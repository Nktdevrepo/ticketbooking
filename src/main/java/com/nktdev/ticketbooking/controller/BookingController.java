package com.nktdev.ticketbooking.controller;

import com.nktdev.ticketbooking.dto.BookingRequestDto;
import com.nktdev.ticketbooking.dto.BookingResponseDto;
import com.nktdev.ticketbooking.service.ITicketBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    ITicketBookingService iTicketBookingService;

    @PostMapping("/bookings")
    ResponseEntity<List<BookingResponseDto>> BookTicket(@RequestBody @Valid BookingRequestDto bookingRequestDto) {
        List<BookingResponseDto> bookingResponseDto = iTicketBookingService.BookTicket(bookingRequestDto);
       return ResponseEntity.ok().body(bookingResponseDto);
    }

    @PostMapping("bookings/{id}/cancel")
    ResponseEntity<List<BookingResponseDto>> CancelTicket(@PathVariable Long id) {
        List<BookingResponseDto> bookingResponseDto = iTicketBookingService.CancelBooking(id);
        return ResponseEntity.ok().body(bookingResponseDto);
    }
}
