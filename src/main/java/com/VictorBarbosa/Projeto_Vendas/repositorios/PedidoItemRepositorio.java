package com.VictorBarbosa.Projeto_Vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VictorBarbosa.Projeto_Vendas.entities.PedidoItem;
import com.VictorBarbosa.Projeto_Vendas.entities.pk.PedidoItemPK;


//Não há a necessidade de Anotação devida a herança feita abaixo, onde já é nomeada como Repositorio no Spring
public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, PedidoItemPK> {

	
	
}
