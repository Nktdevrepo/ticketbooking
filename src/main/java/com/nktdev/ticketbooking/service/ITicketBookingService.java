package com.nktdev.ticketbooking.service;

import com.nktdev.ticketbooking.dto.EventRequestDto;
import com.nktdev.ticketbooking.dto.EventResponseDto;

import java.util.List;

public interface ITicketBookingService {

    //Events
    boolean CreateEvents(EventRequestDto eventRequestDto);
    List<EventResponseDto> GetAllEventDetails();
    List<EventResponseDto> GetEventDetailById(Long Id);

}
