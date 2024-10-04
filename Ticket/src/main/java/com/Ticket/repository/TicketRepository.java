package com.Ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ticket.model.TicketModel;

public interface TicketRepository extends JpaRepository<TicketModel, Integer>{

}
