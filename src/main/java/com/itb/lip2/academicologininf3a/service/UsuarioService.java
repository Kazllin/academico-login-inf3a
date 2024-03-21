package com.itb.lip2.academicologininf3a.service;

import java.util.List;

import com.itb.lip2.academicologininf3a.model.Usuario;



public interface UsuarioService {
	
	Usuario save(Usuario usuario);
	List<Usuario> findAll();
}
