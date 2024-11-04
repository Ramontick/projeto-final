package com.Ticket.controller;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Ticket.model.TicketModel;
import com.Ticket.model.UsuarioModel;
import com.Ticket.repository.TicketRepository;
import com.Ticket.services.UsuarioService;

@Controller
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
    private UsuarioService usuarioService; 
	
	
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
	
	@PostMapping({"/Formulario/salvar"})
    public ModelAndView criarUsuario(UsuarioModel usuario) {
        usuarioService.salvarUsuario(usuario);
          
        return new ModelAndView("redirect:/listarTickets");
    }
	
	
	@GetMapping({"/logar"})
	public String TelaDeLogin() {
	return "logar";
	}
	
	@GetMapping({"/Home"})
	public String Home() {
	return "Home";
	}
	@GetMapping({"/teste"})
	public String teste() {
	return "teste";
	}
	
	 @GetMapping("usuario-{id}")
	  public String busca(@PathVariable int id, Model model){
	    Optional<TicketModel> ticket =  ticketRepository.findById(id);
	    try{
	      model.addAttribute("ticket", ticket.get());
	    }
	    catch(Exception err){ return "redirect:/"; }

		return ("Formulario-visualizar");
	  }

	 
	 
	 @SuppressWarnings("deprecation")
	@GetMapping("/deleteTicket-{id}")
		public String Deletar(TicketModel ticket,@PathVariable("id") int id ) {
		ticket = (TicketModel)this.ticketRepository.getOne(id);
		this.ticketRepository.delete(ticket);

		return"redirect:/";
	}
	
	
	
	
}
