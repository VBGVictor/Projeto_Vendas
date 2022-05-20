package com.VictorBarbosa.Projeto_Vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VictorBarbosa.Projeto_Vendas.entities.Categoria;
import com.VictorBarbosa.Projeto_Vendas.repositorios.CategoriaRepositorio;

@Service//registra sua classe como um Serviço do Spring e vai poder ser injetado automaticamente
public class CategoriaServico {

	@Autowired //Comando de injeção de dependecia do Spring
	private CategoriaRepositorio repositorio;//Dependencia
	
	public List<Categoria> findAll(){
		return repositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
