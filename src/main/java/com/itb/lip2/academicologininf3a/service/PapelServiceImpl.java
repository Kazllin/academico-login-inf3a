package com.itb.lip2.academicologininf3a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itb.lip2.academicologininf3a.model.Papel;
import com.itb.lip2.academicologininf3a.repository.PapelRepository;
import com.itb.lip2.academicologininf3a.repository.UsuarioRepository;

@Service
public class PapelServiceImpl implements PapelService {
	
	@Autowired
	private PapelRepository papelRepository;

	@Override
	public Papel save(Papel papel) {
		// TODO Auto-generated method stub
		return papelRepository.save(papel);
	}

	@Override
	public List<Papel> findAll() {
		// TODO Auto-generated method stub
		return papelRepository.findAll();
	}
	
	
}
