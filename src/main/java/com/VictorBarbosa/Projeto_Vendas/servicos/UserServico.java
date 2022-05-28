package com.VictorBarbosa.Projeto_Vendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.repositorios.UserRepositorio;
import com.VictorBarbosa.Projeto_Vendas.servicos.exceptions.RecursosNaoEcontradoExcessao;

@Service//registra sua classe como um Serviço do Spring e vai poder ser injetado automaticamente
public class UserServico {

	@Autowired //Comando de injeção de dependecia do Spring
	private UserRepositorio repositorio;//Dependencia
	
	public List<User> findAll(){
		return repositorio.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursosNaoEcontradoExcessao(id));
	}
	
	public User insert(User obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	//não funcionou "org.hibernate.LazyInitializationException: could not initialize proxy.." aparece esta exceção quando tento fazer um update
	public User update(Long id, User obj) {
		User entity = repositorio.getById(id); //Prepara o objeto no banco de dados para alguma alteração ao inves de traze-lo como o findById
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setCelular(obj.getCelular());
		
	}
}
