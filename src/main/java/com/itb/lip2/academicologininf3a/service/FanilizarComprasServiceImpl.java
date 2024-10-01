package com.itb.lip2.academicologininf3a.service;

import com .itb.lip2.academicologininf3a.model.CarrinhoCompras;
import com.itb.lip2.academicologininf3a.model.FinalizarCompras;
import com.itb.lip2.academicologininf3a.repository.CarrinhoComprasRepository;
import com.itb.lip2.academicologininf3a.repository.FinalizarComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FanilizarComprasServiceImpl implements FinalizarComprasService {

    @Autowired
    private FinalizarComprasRepository finalizarComprasRepository;

    @Autowired
    private CarrinhoComprasRepository carrinhoComprasRepository;

    @Override
    public FinalizarCompras save(FinalizarCompras finalizarCompras) {
        return finalizarComprasRepository.save(finalizarCompras);
    }

    @Override
    @Transactional
    public void finalizarCompras(Long carrinhoComprasId, String formaPagamento) {
        CarrinhoCompras carrinhoCompras = carrinhoComprasRepository.findById(carrinhoComprasId).orElseThrow(() -> new RuntimeException("Carrinho de compras não encontrado!"));
        FinalizarCompras finalizarCompras = new FinalizarCompras();
        finalizarCompras.setCarrinhoComprasId(carrinhoComprasId);
        finalizarCompras.setValorTotal(carrinhoCompras.getValorTotal());
        finalizarCompras.setFormaPagamento(formaPagamento);
        finalizarComprasRepository.save(finalizarCompras);
        carrinhoCompras.setValorTotal(0);
        carrinhoCompras.getProdutos().clear();
        carrinhoComprasRepository.save(carrinhoCompras);
    }
}