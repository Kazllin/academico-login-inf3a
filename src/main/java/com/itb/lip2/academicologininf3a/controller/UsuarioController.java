package com.itb.lip2.academicologininf3a.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.academicologininf3a.model.Usuario;
import com.itb.lip2.academicologininf3a.repository.UsuarioRepository;
import com.itb.lip2.academicologininf3a.service.UsuarioService;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@GetMapping("/User")
	public ResponseEntity<List<Usuario>> getUsers() {
		
		return ResponseEntity.ok().body(usuarioService.findAll()) ;
	}
	
	@PostMapping("/User")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
		
		URI uri = URI.create(ServletUriComponentsBuilder .fromCurrentContextPath().path("/api/v1/User").toUriString());
		
		return ResponseEntity.ok().body(usuarioService.save(usuario));
		
		
	}
	
	
}
