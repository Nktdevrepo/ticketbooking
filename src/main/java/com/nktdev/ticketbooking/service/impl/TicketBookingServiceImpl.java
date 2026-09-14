package com.nktdev.ticketbooking.service.impl;

import com.nktdev.ticketbooking.dto.EventRequestDto;
import com.nktdev.ticketbooking.dto.EventResponseDto;
import com.nktdev.ticketbooking.entity.Event;
import com.nktdev.ticketbooking.repository.EventRepository;
import com.nktdev.ticketbooking.service.ITicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public boolean CreateEvents(EventRequestDto eventRequestDto) {
        Event event = TransformDtoToEntity(eventRequestDto);
        Event savedEvent = eventRepository.save(event);
        return savedEvent.getId()!=null && savedEvent.getId()>0;
    }


    @Override
    public List<EventResponseDto> GetAllEventDetails() {
        return List.of();
    }

    @Override
    public List<EventResponseDto> GetEventDetailById(Long Id) {
        return List.of();
    }

    private Event TransformDtoToEntity(EventRequestDto eventRequestDto) {
        Event event = new Event();
        event.setTitle(eventRequestDto.getTitle());
        event.setEventDate(eventRequestDto.getEventDate());
        event.setAvailableSeats(eventRequestDto.getTotalCapacity());
        event.setTotalCapacity(eventRequestDto.getTotalCapacity());
        event.setLocation(eventRequestDto.getLocation());
        return event;
    }

}
