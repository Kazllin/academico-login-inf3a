package com.itb.lip2.academicologininf3a.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "Cliente")

public class Cliente extends Usuario {

    private String rm;


    public Cliente() {


    }

    public Cliente(Long id, String nome, String email, String senha, String tipoUsuario, Collection<Papel> papeis) {

        super(id, nome,email, senha,tipoUsuario, papeis);  // Acesso ao construtor da class pai

    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }
}