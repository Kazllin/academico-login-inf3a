package com.itb.lip2.academicologininf3a.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;


@Entity
@DiscriminatorValue(value = "Professor")
public class Professor extends Usuario{

    private int pontuacao;
    private String nivelProfissonal;

    public Professor(Long id, String nome, String email, String senha, Collection<Papel> papeis) {
        super(id, nome, email, senha, papeis);
    }

    public Professor(){

    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNivelProfissonal() {
        return nivelProfissonal;
    }

    public void setNivelProfissonal(String nivelProfissonal) {
        this.nivelProfissonal = nivelProfissonal;
    }
}
