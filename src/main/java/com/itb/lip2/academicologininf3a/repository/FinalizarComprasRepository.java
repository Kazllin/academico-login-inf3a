package com.itb.lip2.academicologininf3a.repository;

import com.itb.lip2.academicologininf3a.model.FinalizarCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalizarComprasRepository extends JpaRepository<FinalizarCompras, Long> {
}