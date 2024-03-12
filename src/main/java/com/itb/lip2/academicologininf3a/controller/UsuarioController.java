package com.itb.lip2.academicologininf3a.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itb.lip2.academicologininf3a.model.Usuario;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@GetMapping("/User")
	public List<Usuario> getUsers() {
		
		List<Usuario> usuarios =  new ArrayList<Usuario>();
	
		Usuario us1 = new Usuario();
		us1.setId(1l);
		us1.setNome("Marcos");
		us1.setEmail("Marcos@gmail.com");
		
		Usuario us2 = new Usuario();
		us2.setId(2l);
		us2.setNome("Marcos");
		us2.setEmail("Marcos@gmail.com");
		
		usuarios.add(us1);
		usuarios.add(us2);
		return usuarios;
		
	}
}
