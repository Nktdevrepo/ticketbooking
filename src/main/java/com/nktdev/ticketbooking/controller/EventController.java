package com.nktdev.ticketbooking.controller;

import com.nktdev.ticketbooking.dto.EventRequestDto;
import com.nktdev.ticketbooking.service.ITicketBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
