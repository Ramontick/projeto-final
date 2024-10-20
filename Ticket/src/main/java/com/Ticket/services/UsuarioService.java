package com.Ticket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Ticket.model.UsuarioModel;
import com.Ticket.model.UsuarioPermissao;
import com.Ticket.repository.UsuarioPermissaoRepository;
import com.Ticket.repository.UsuarioRepository;

@Service
public class UsuarioService{

		@Autowired
		private UsuarioRepository usuarioRepository;

		@Autowired
		private  UsuarioPermissaoRepository usuarioPermissaoRepository;


		   public void salvarUsuario(UsuarioModel usuario) {
			BCryptPasswordEncoder b = new BCryptPasswordEncoder();  
			System.out.println(usuario.getSenha());
			String senhaCriptografada = b.encode(usuario.getSenha());
			System.out.println(senhaCriptografada);
			usuario.setSenha(senhaCriptografada);
		    UsuarioModel usuarioSalvo = usuarioRepository.save(usuario);
		    Long usuarioIdSalvo = usuarioSalvo.getId_usuario();
		    long usuarioPermissaoSalva = usuarioSalvo.getPermissao();
		    
		    UsuarioPermissao usuarioPermissao = new UsuarioPermissao();
		    usuarioPermissao.setUsuarioId(usuarioIdSalvo);
		    usuarioPermissao.setPermissaoId(usuarioPermissaoSalva);
		    usuarioPermissaoRepository.save(usuarioPermissao);


		   }
	
}
