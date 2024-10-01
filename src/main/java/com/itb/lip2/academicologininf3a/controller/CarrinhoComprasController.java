package com.itb.lip2.academicologininf3a.controller;

import com.itb.lip2.academicologininf3a.model.CarrinhoCompras;
import com.itb.lip2.academicologininf3a.model.Produto;
import com.itb.lip2.academicologininf3a.service.CarrinhoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academico/api/v1/cliente")
public class CarrinhoComprasController {

    @Autowired
    private CarrinhoComprasService carrinhoComprasService;

    @PostMapping("/carrinho-compras")
    public ResponseEntity<CarrinhoCompras> save(@RequestBody CarrinhoCompras carrinhoCompras) {
        return ResponseEntity.ok().body(carrinhoComprasService.save(carrinhoCompras));
    }

    @GetMapping("/carrinho-compras")
    public ResponseEntity<List<CarrinhoCompras>> findAll() {
        return ResponseEntity.ok().body(carrinhoComprasService.findAll());
    }

    @GetMapping("/carrinho-compras/{id}")
    public ResponseEntity<Optional<CarrinhoCompras>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(carrinhoComprasService.findById(id));
    }

    @PutMapping("/carrinho-compras/{id}")
    public ResponseEntity<CarrinhoCompras> update(@PathVariable Long id, @RequestBody CarrinhoCompras carrinhoCompras) throws Exception {
        return ResponseEntity.ok().body(carrinhoComprasService.update(id, carrinhoCompras));
    }

    @PostMapping("/{id}/adicionar-produto")
    public ResponseEntity<CarrinhoCompras> adicionarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        carrinhoComprasService.adicionarProduto(id, produto);
        return ResponseEntity.ok().body(carrinhoComprasService.findById(id).orElseThrow(() -> new RuntimeException("Carrinho de compras não encontrado!")));
    }

    @PostMapping("/{id}/remover-produto")
    public ResponseEntity<CarrinhoCompras> removerProduto(@PathVariable Long id, @RequestBody Produto produto) {
        carrinhoComprasService.removerProduto(id, produto);
        return ResponseEntity.ok().body(carrinhoComprasService.findById(id).orElseThrow(() -> new RuntimeException("Carrinho de compras não encontrado!")));
    }
}