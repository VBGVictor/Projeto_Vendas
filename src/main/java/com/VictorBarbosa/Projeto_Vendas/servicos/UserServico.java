package com.VictorBarbosa.Projeto_Vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.repositorios.UserRepositorio;

@Service//registra sua classe como um Serviço do Spring e vai poder ser injetado automaticamente
public class UserServico {

	@Autowired //Comando de injeção de dependecia do Spring
	private UserRepositorio repositorio;//Dependencia
	
	public List<User> findAll(){
		return repositorio.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repositorio.findById(id);
		return obj.get();
	}
}
