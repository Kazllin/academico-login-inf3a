package com.itb.lip2.academicologininf3a.controller;

import com.itb.lip2.academicologininf3a.model.FinalizarCompras;
import com.itb.lip2.academicologininf3a.service.FinalizarComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academico/api/v1/finalizar-compras")
public class FinalizarComprasController {

    @Autowired
    private FinalizarComprasService finalizarComprasService;

    @PostMapping
    public ResponseEntity<FinalizarCompras> save(@RequestBody FinalizarCompras finalizarCompras) {
        return ResponseEntity.ok().body(finalizarComprasService.save(finalizarCompras));
    }

    @PostMapping("/{carrinhoComprasId}/finalizar")
    public ResponseEntity<Void> finalizarCompras(@PathVariable Long carrinhoComprasId, @RequestParam String formaPagamento) {
        finalizarComprasService.finalizarCompras(carrinhoComprasId, formaPagamento);
        return ResponseEntity.ok().build();
    }
}