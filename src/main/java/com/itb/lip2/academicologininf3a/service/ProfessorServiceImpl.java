package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.Professor;
import com.itb.lip2.academicologininf3a.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository professorRepository;
    ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Transactional
    @Override
    public Professor update(Long id, Professor professor) throws Exception {
        return professorRepository.findById(id).map(prof ->{
            prof.setNome(professor.getNome());
            prof.setEmail(professor.getEmail());
            prof.setDataNascimento(professor.getDataNascimento());
            prof.setPontuacao(professor.getPontuacao());
            prof.setNivelProfissional(professor.getNivelProfissional());
            prof.setCodStatusUsuario(professor.isCodStatusUsuario());
            return professorRepository.save(prof);
        }).orElseThrow(()->new Exception("Professor não encontrado!"));
    }
}