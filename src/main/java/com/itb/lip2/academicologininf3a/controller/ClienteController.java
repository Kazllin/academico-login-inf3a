package com.itb.lip2.academicologininf3a.controller;

import com.itb.lip2.academicologininf3a.model.Cliente;
import com.itb.lip2.academicologininf3a.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academico/api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    ClienteController (ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateCliente(@RequestBody Cliente cliente, @PathVariable(value="id") Long id) {
        try {
            return ResponseEntity.ok().body(clienteService.update(id, cliente));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}