package com.itb.lip2.academicologininf3a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itb.lip2.academicologininf3a.model.Papel;
import com.itb.lip2.academicologininf3a.model.Usuario;
import com.itb.lip2.academicologininf3a.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findUserById(Long id) {

		return usuarioRepository.getById(id);
	}


}
