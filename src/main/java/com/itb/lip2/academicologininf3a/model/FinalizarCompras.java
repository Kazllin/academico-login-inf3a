package com.itb.lip2.academicologininf3a.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "finalizar_compras")
public class FinalizarCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long carrinhoComprasId;

    private double valorTotal;

    private String formaPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarrinhoComprasId() {
        return carrinhoComprasId;
    }

    public void setCarrinhoComprasId(Long carrinhoComprasId) {
        this.carrinhoComprasId = carrinhoComprasId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}