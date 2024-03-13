package com.itb.lip2.academicologininf3a.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "papeis")
public class Papel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String NomePapel;
	private String DescricaoPapel;
	private boolean codStatusPapel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePapel() {
		return NomePapel;
	}
	public void setNomePapel(String nomePapel) {
		NomePapel = nomePapel;
	}
	public String getDescricaoPapel() {
		return DescricaoPapel;
	}
	public void setDescricaoPapel(String descricaoPapel) {
		DescricaoPapel = descricaoPapel;
	}
	public boolean isCodStatusPapel() {
		return codStatusPapel;
	}
	public void setCodStatusPapel(boolean codStatusPapel) {
		this.codStatusPapel = codStatusPapel;
	}
	
	
}
