package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.CarrinhoCompras;
import com.itb.lip2.academicologininf3a.model.Produto;
import com.itb.lip2.academicologininf3a.repository.CarrinhoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoComprasServiceImpl implements CarrinhoComprasService {

    @Autowired
    private CarrinhoComprasRepository carrinhoComprasRepository;

    @Override
    public CarrinhoCompras save(CarrinhoCompras carrinhoCompras) {
        return carrinhoComprasRepository.save(carrinhoCompras);
    }

    @Override
    public List<CarrinhoCompras> findAll() {
        return carrinhoComprasRepository.findAll();
    }

    @Override
    public Optional<CarrinhoCompras> findById(Long id) {
        return carrinhoComprasRepository.findById(id);
    }

    @Override
    @Transactional
    public CarrinhoCompras update(Long id, CarrinhoCompras carrinhoCompras) throws Exception {
        return carrinhoComprasRepository.findById(id).map(cc -> {
            cc.setUsuarioId(carrinhoCompras.getUsuarioId());
            cc.setProdutos(carrinhoCompras.getProdutos());
            cc.setValorTotal(carrinhoCompras.getValorTotal());
            return carrinhoComprasRepository.save(cc);
        }).orElseThrow(() -> new Exception("Carrinho de compras não encontrado!"));
    }

    @Override
    public void adicionarProduto(Long id, Produto produto) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho de compras não encontrado!"));
        carrinhoCompras.getProdutos().add(produto);
        carrinhoCompras.setValorTotal(carrinhoCompras.getValorTotal() + produto.getPreco());
        carrinhoComprasRepository.save(carrinhoCompras);
    }

    @Override
    public void removerProduto(Long id, Produto produto) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho de compras não encontrado!"));
        carrinhoCompras.getProdutos().remove(produto);
        carrinhoCompras.setValorTotal(carrinhoCompras.getValorTotal() - produto.getPreco());
        carrinhoComprasRepository.save(carrinhoCompras);
    }
}