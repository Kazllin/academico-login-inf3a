package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.Curso;
import com.itb.lip2.academicologininf3a.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CursoService {
 List<Curso> findAll();


}