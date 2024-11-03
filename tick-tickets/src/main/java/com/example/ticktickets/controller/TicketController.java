package com.example.ticktickets.controller;

import com.example.ticktickets.model.Ticket;
import com.example.ticktickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Método para a página inicial
    @GetMapping
    public String home() {
        return "home"; // Retorna a página home
    }

    @GetMapping("/tickets")
    public String getAllTickets(Model model) {
        model.addAttribute("tickets", ticketService.findAll());
        return "tickets";
    }

    @GetMapping("/tickets/new")
    public String showNewTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/tickets")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/tickets/edit/{id}")
    public String showEditTicketForm(@PathVariable Long id, Model model) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            return "ticket-form";
        }
        return "redirect:/tickets";
    }

    @GetMapping("/tickets/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return "redirect:/tickets";
    }
}
