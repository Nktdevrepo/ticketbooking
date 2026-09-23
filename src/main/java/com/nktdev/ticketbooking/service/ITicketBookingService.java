package com.nktdev.ticketbooking.service;

import com.nktdev.ticketbooking.dto.*;

import java.util.List;

public interface ITicketBookingService {

    //Events
    boolean CreateEvents(EventRequestDto eventRequestDto);
    List<EventResponseDto> GetAllEventDetails();
    List<EventResponseDto> GetEventDetailById(Long Id);

    //User
    boolean CreateUser(UserRequestDto userRequestDto);
    List<UserResponseDto> GetAllUsers();
    List<UserResponseDto> GetUsersById(Long Id);

    //Ticket Booking
    boolean BookTicket(BookingRequestDto bookingRequestDto);

}
