package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.FinalizarCompras;

public interface FinalizarComprasService {

    FinalizarCompras save(FinalizarCompras finalizarCompras);

    void finalizarCompras(Long carrinhoComprasId, String formaPagamento);
}