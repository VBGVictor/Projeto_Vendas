package com.VictorBarbosa.Projeto_Vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VictorBarbosa.Projeto_Vendas.entities.Produto;
import com.VictorBarbosa.Projeto_Vendas.repositorios.ProdutoRepositorio;

@Service//registra sua classe como um Serviço do Spring e vai poder ser injetado automaticamente
public class ProdutoServico {

	@Autowired //Comando de injeção de dependecia do Spring
	private ProdutoRepositorio repositorio;//Dependencia
	
	public List<Produto> findAll(){
		return repositorio.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
