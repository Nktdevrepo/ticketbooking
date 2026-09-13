package com.nktdev.ticketbooking.repository;

import com.nktdev.ticketbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
