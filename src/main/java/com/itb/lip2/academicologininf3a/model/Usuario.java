package com.itb.lip2.academicologininf3a.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn ( name = "tipoUsuario", discriminatorType = DiscriminatorType.STRING)
@EnableJpaAuditing
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoUsuario" )
@JsonSubTypes({
		@JsonSubTypes.Type(value = Aluno.class, name = "Aluno"),
		@JsonSubTypes.Type(value = Professor.class, name = "Professor")
})
public abstract class Usuario {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private boolean  codStatusUsuario;
	private LocalDate dataNascimento;

	@Column(insertable = false, updatable = false)
	private String tipoUsuario;
	// FetchType.EAGER -> tRAZ TODOS OS REGISTROS RELACIONADOS
	// FetchType.LAZY -> NAO TRAZ TODOS OS REGISTROS RELACIONADOS
	
	
	@ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="usuarios_papeis",
			joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="papel_id", referencedColumnName = "id")
			)
	
	private Collection<Papel> papeis;


	public Usuario(){

	}
	public Usuario(Long id, String nome, String email, String senha, Collection<Papel> papeis) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.papeis = papeis;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

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
