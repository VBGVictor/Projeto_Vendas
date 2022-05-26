package com.VictorBarbosa.Projeto_Vendas.entities;

import java.io.Serializable;
import java.time.Instant;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.VictorBarbosa.Projeto_Vendas.entities.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer statusPedido;

	                                                               // @JsonIgnore //Esta anotação irá impedir o lop infinito causado pela ligação
	                                                                              // da lista com os pedidos
	                                                                              // Tambem serve para definir quem carregará os dados ligados entre si
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private User cliente;

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy = "id.pedido")  //Este mapeamento não estava conseguindo relacionar com o 'id.pedidos' da classe
	private Set<PedidoItem> Items = new HashSet<>();                                       //PeidoItemPK que se trata de uma classe que intermedia a relação, logo, tive que colocar
																						   //O comando 'EAGER' e 'CascadeType.ALL' para forçar e puxar a relação
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)  
	private Pagamento pagamento;
	
	public Pedido() {
	}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido, User cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<PedidoItem> getItems() {
		return Items;
	}
	
	
	public StatusPedido getStatusPedido() {
		return StatusPedido.valueOf(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null)
		this.statusPedido = statusPedido.getCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
