package com.itb.lip2.academicologininf3a.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private boolean  codStatusUsuario;
	private LocalDate dataNascimento;
	
	// FetchType.EAGER -> tRAZ TODOS OS REGISTROS RELACIONADOS
	// FetchType.LAZY -> NAO TRAZ TODOS OS REGISTROS RELACIONADOS
	
	
	@ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="usuarios_papeis",
			joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="papel_id", referencedColumnName = "id")
			)
	
	private Collection<Papel> papeis;
	
	public Collection<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(Collection<Papel> papeis) {
		this.papeis = papeis;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isCodStatusUsuario() {
		return codStatusUsuario;
	}
	public void setCodStatusUsuario(boolean codStatusUsuario) {
		this.codStatusUsuario = codStatusUsuario;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
