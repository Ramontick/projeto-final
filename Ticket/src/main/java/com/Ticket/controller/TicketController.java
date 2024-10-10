package com.Ticket.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Ticket.model.TicketModel;
import com.Ticket.repository.TicketRepository;

@Controller
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping({"/"})
	public String start() {
	return "Formulario";
	}
	
	@PostMapping({"/Formulario/save"})
	public ModelAndView TicketSave(TicketModel ticket) {
	ModelAndView mv = new ModelAndView("redirect:/");
	ticket.setData_criacao(LocalDateTime.now());
	ticketRepository.save(ticket);
		return mv;
	}
	
	@GetMapping("/listarTickets")
	public String listarTickets(Model ticket) {
		ticket.addAttribute("ticket", ticketRepository.findAll());
		return "/Home";
	}
	
	@GetMapping({"/Formulario"})
	public String Formulario() {
	return "Formulario";
	}
	
	@GetMapping({"/cadastrar-usuario"})
	public String cadastrarUsuario() {
	return "cadastrar-usuario";
	}
	
	@GetMapping({"/logar"})
	public String TelaDeLogin() {
	return "logar";
	}
	
	@GetMapping({"/Home"})
	public String Home() {
	return "Home";
	}
	
	
}
