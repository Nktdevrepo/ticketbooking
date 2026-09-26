package com.nktdev.ticketbooking.controller;

import com.nktdev.ticketbooking.dto.UserRequestDto;
import com.nktdev.ticketbooking.dto.UserResponseDto;
import com.nktdev.ticketbooking.service.ITicketBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    ITicketBookingService iTicketBookingService;

    @PostMapping("/users")
    ResponseEntity<String> CreateUser(@RequestBody @Valid UserRequestDto userRequestDto) {

        boolean created = iTicketBookingService.CreateUser(userRequestDto);
        if(created) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User Created Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User Creation Failed");
        }
    }

    @GetMapping("/user")
    ResponseEntity<List<UserResponseDto>> GetAllUsers() {
        List<UserResponseDto> userResponseDto = iTicketBookingService.GetAllUsers();
        return ResponseEntity.ok().body(userResponseDto);
    }

    @GetMapping("user/{id}")
    ResponseEntity<List<UserResponseDto>> GetUserById(@PathVariable Long id) {
        List<UserResponseDto> userResponseDto = iTicketBookingService.GetUsersById(id);
        return ResponseEntity.ok().body(userResponseDto);
    }
}
