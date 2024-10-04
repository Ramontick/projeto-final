package com.Ticket.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name="ticket", schema = "ticket")
	public class TicketModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		
		@Column(name = "nome")
		private String nome;
		
		@Column(name = "email")
		private String email;

		@Column(name = "telefone")
		private String telefone;
		
		@Column(name = "titulo")
		private String titulo;
		
		@Column(name = "descricao")
		private String descricao;

		@Column(name = "situcacao")
		private boolean situacao;
		
		@Column(name = "data_criacao")
		private Date data_criacao;

	
}
