package com.VictorBarbosa.Projeto_Vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VictorBarbosa.Projeto_Vendas.entities.Pedido;
import com.VictorBarbosa.Projeto_Vendas.repositorios.PedidoRepositorio;

@Service//registra sua classe como um Serviço do Spring e vai poder ser injetado automaticamente
public class PedidoServico {

	@Autowired //Comando de injeção de dependecia do Spring
	private PedidoRepositorio repositorio;//Dependencia
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
