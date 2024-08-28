package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.Professor;

public interface ProfessorService {

    Professor update(Long id, Professor professor) throws Exception;
}