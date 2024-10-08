package com.itb.lip2.academicologininf3a.repository;

import com.itb.lip2.academicologininf3a.model.CarrinhoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoComprasRepository extends JpaRepository<CarrinhoCompras, Long> {
}