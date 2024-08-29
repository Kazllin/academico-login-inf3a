package com.itb.lip2.academicologininf3a.service;

import java.util.List;
import java.util.Optional;

import com.itb.lip2.academicologininf3a.model.Papel;
import com.itb.lip2.academicologininf3a.model.Professor;
import com.itb.lip2.academicologininf3a.model.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);
	Usuario saveProfessor(Professor professor);
	List<Usuario> findAll();
	Optional<Usuario> findById(Long id);
	Usuario update(Long id, Usuario usuario) throws Exception;
	Papel savePapel(Papel papel);
	void addPapelToUsuario(Usuario usuario, String nomePapel);

	Usuario findByUsername(String username);



}