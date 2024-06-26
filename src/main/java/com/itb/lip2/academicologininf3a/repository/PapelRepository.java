package com.itb.lip2.academicologininf3a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.lip2.academicologininf3a.model.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {
	
	Papel getPapelById(Long id);

}

