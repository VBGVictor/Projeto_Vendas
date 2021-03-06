package com.VictorBarbosa.Projeto_Vendas.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	                                                                         // Set é uma interface e não pode ser instanciado, então usamos a classe
	                                                                         // correspondente a esta interface (HasdSet).
	                                                                         // O Set representa um conjunto, pois, garantirá que não terá um produto com
	                                                                         // mais de uma ocorrencia de categoria.
	
	@ManyToMany(fetch = FetchType.EAGER,
			cascade = {CascadeType.ALL})
	@JoinTable(name = "tb_produto_categoria", joinColumns = {@JoinColumn(name = "produto_id")}, inverseJoinColumns = {@JoinColumn(name = "categoria_id")})
	private Set<Categoria> categorias = new HashSet<>();// Para garantir que a coleção não comece valendo null

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy = "id.produto")
	private Set<PedidoItem> items = new HashSet<>();
	
	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, Double preco, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
	@JsonIgnore                                     //Este JsonIgnore servirá para que quando um pedido for buscado apareça
	public Set<Pedido> getPedidos() {               //Os produtos a ele associados 
		Set<Pedido> set = new HashSet<>();
		for (PedidoItem x : items) {
			set.add(x.getPedido());
		}
		return set;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
