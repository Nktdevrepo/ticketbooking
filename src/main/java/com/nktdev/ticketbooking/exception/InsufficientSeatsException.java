package com.nktdev.ticketbooking.exception;

public class InsufficientSeatsException extends RuntimeException{

    public InsufficientSeatsException(String message) {
        super(message);
    }
}
