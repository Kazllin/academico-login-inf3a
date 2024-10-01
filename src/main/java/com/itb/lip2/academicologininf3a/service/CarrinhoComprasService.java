package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.CarrinhoCompras;
import com.itb.lip2.academicologininf3a.model.Produto;

import java.util.List;
import java.util.Optional;

public interface CarrinhoComprasService {

    CarrinhoCompras save(CarrinhoCompras carrinhoCompras);

    List<CarrinhoCompras> findAll();

    Optional<CarrinhoCompras> findById(Long id);

    CarrinhoCompras update(Long id, CarrinhoCompras carrinhoCompras) throws Exception;

    void adicionarProduto(Long id, Produto produto);

    void removerProduto(Long id, Produto produto);
}