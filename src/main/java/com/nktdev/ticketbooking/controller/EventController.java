package com.nktdev.ticketbooking.controller;

import com.nktdev.ticketbooking.dto.EventRequestDto;
import com.nktdev.ticketbooking.dto.EventResponseDto;
import com.nktdev.ticketbooking.service.ITicketBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    ITicketBookingService iTicketBookingService;

    @PostMapping("/events")
    ResponseEntity<String> CreateNewEvent(@RequestBody @Valid EventRequestDto eventRequestDto) {

        boolean created = iTicketBookingService.CreateEvents(eventRequestDto);
        if(created) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Event Created Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Event Creation Failed");
        }

    }

    @GetMapping("/events")
    ResponseEntity<List<EventResponseDto>> GetAllUpcomingEvents() {
        List<EventResponseDto> eventResponseDto = iTicketBookingService.GetAllEventDetails();
        return ResponseEntity.ok().body(eventResponseDto);
    }

    @GetMapping("/events/{id}")
    ResponseEntity<List<EventResponseDto>> GetEventById(@PathVariable Long id) {
        List<EventResponseDto> eventResponseDto = iTicketBookingService.GetEventDetailById(id);
        return ResponseEntity.ok().body(eventResponseDto);
    }
}
