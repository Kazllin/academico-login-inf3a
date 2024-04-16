package com.itb.lip2.academicologininf3a.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.academicologininf3a.model.Usuario;
import com.itb.lip2.academicologininf3a.service.UsuarioService;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@GetMapping("/user")
	public ResponseEntity<List<Usuario>> getUsers() {
		
		return ResponseEntity.ok().body(usuarioService.findAll()) ;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/User").toUriString());
		
		return ResponseEntity.ok().body(usuarioService.save(usuario));
		
		
	}
@GetMapping("/user/{id}")
	public ResponseEntity<Usuario> findUserById(@PathVariable(value = "id") Long id, ModelMap model, Usuario usuario){

		return ResponseEntity.ok().body(usuarioService.findUserById(id));
	}
}
