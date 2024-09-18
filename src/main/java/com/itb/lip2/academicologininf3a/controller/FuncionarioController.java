package com.itb.lip2.academicologininf3a.controller;

import java.net.URI;
import java.util.List;

import com.itb.lip2.academicologininf3a.exceptions.NotFound;
import com.itb.lip2.academicologininf3a.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.academicologininf3a.service.ProdutoService;

@RestController
@RequestMapping("/academico/api/v1")
public class FuncionarioController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/funcionario")
    public ResponseEntity<List<Produto>> getProdutos() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @PostMapping("/funcionario")
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/funcionario").toUriString());
        return ResponseEntity.created(uri).body(produtoService.save(produto));
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Object> findProdutoById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(produtoService.findById(id).get());
        } catch (Exception e) {
            throw new NotFound("Usuario nao encontrado " + id);
        }
    }

    @PutMapping("/funcionario/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
        try {
            return ResponseEntity.ok().body(produtoService.update(id, produto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}