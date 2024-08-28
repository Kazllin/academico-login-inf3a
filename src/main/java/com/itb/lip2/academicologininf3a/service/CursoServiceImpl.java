package com.itb.lip2.academicologininf3a.service;


import com.itb.lip2.academicologininf3a.model.Curso;
import com.itb.lip2.academicologininf3a.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
}