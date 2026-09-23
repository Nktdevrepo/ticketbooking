package com.nktdev.ticketbooking.service.impl;

import com.nktdev.ticketbooking.dto.*;
import com.nktdev.ticketbooking.entity.Event;
import com.nktdev.ticketbooking.entity.User;
import com.nktdev.ticketbooking.exception.ResourceNotFoundException;
import com.nktdev.ticketbooking.repository.EventRepository;
import com.nktdev.ticketbooking.repository.UserRepository;
import com.nktdev.ticketbooking.service.ITicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean CreateEvents(EventRequestDto eventRequestDto) {
        Event event = TransformDtoToEntity(eventRequestDto);
        Event savedEvent = eventRepository.save(event);
        return savedEvent.getId()!=null && savedEvent.getId()>0;
    }


    @Override
    public List<EventResponseDto> GetAllEventDetails() {
        List<Event> EventList = eventRepository.findAll();
        return EventList.stream().map(this::ConvertEventToDto).collect(Collectors.toList());
    }

    @Override
    public List<EventResponseDto> GetEventDetailById(Long Id) {
        Event event = eventRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + Id));
        return List.of(ConvertEventToDto(event));

    }

    @Override
    public boolean CreateUser(UserRequestDto userRequestDto) {
        User user = TransformUserDtoToEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId()!=null && savedUser.getId()>0;
    }

    @Override
    public List<UserResponseDto> GetAllUsers() {
       List<User> user = userRepository.findAll();
       return user.stream().map(this::ConvertUserToDto).collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> GetUsersById(Long Id) {
        User user = userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + Id));
        return List.of(ConvertUserToDto(user));
    }

    @Override
    public boolean BookTicket(BookingRequestDto bookingRequestDto) {

        return false;
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

    private EventResponseDto ConvertEventToDto(Event event) {
        EventResponseDto eventResponseDto = new EventResponseDto();
        eventResponseDto.setId(event.getId());
        eventResponseDto.setTitle(event.getTitle());
        eventResponseDto.setLocation(event.getLocation());
        eventResponseDto.setEventDate(event.getEventDate());
        eventResponseDto.setAvailableSeats(event.getAvailableSeats());
        eventResponseDto.setTotalCapacity(eventResponseDto.getTotalCapacity());
        return eventResponseDto;
    }

    private User TransformUserDtoToEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        return user;
    }

    private UserResponseDto ConvertUserToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

}
