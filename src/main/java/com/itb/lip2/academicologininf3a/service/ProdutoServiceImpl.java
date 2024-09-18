package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.Produto;
import com.itb.lip2.academicologininf3a.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    @Transactional
    public Produto update(Long id, Produto produto) throws Exception {
        return produtoRepository.findById(id).map(p -> {
            p.setNome(produto.getNome());
            p.setDescricao(produto.getDescricao());
            p.setPreco(produto.getPreco());
            p.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(p);
        }).orElseThrow(() -> new Exception("Produto não encontrado!"));
    }

}