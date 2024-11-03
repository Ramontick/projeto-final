package com.example.ticktickets.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticktickets.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUsername(String username);
}
