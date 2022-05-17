package com.VictorBarbosa.Projeto_Vendas.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {	
	                                                   // Interface necessária para transformar os obj's em cadeias de bites.
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String celular;
	private String senha;
	
	public User() {
	}

	public User(Long id, String nome, String email, String celular, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
}
