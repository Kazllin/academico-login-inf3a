package com.itb.lip2.academicologininf3a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.lip2.academicologininf3a.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value = "SELECT * FROM usuarios u WHERE u.email=?", nativeQuery = true)
	Usuario findByEmail(String email);

	Usuario getUsuarioById(Long id);
}
