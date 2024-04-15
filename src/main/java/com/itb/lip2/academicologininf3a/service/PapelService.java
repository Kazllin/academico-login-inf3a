package com.itb.lip2.academicologininf3a.service;

import java.util.List;

import com.itb.lip2.academicologininf3a.model.Papel;



public interface PapelService {

	Papel save(Papel papel);
	List<Papel> findAll();

}
