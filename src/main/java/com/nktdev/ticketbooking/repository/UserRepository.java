package com.nktdev.ticketbooking.repository;

import com.nktdev.ticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
