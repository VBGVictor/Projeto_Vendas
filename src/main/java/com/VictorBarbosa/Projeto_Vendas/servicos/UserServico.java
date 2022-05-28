package com.VictorBarbosa.Projeto_Vendas.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.repositorios.UserRepositorio;
import com.VictorBarbosa.Projeto_Vendas.servicos.exceptions.BaseDadosExcessoes;
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
		try {
		repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {  //Antes de colocar a EmptyResult foi colocado a RunTimeException para encontra qual fosse a excessão gerada e poder captura-la
			throw new RecursosNaoEcontradoExcessao(id);
		} catch (DataIntegrityViolationException e) {
			throw new BaseDadosExcessoes(e.getMessage());
		}
	}
	//não funcionou "org.hibernate.LazyInitializationException: could not initialize proxy.." aparece esta exceção quando tento fazer um update
	public User update(Long id, User obj) {
		try {
		User entity = repositorio.getById(id); //Prepara o objeto no banco de dados para alguma alteração ao inves de traze-lo como o findById
		updateData(entity, obj);
		return repositorio.save(entity);
		} catch (EntityNotFoundException e) {
			throw new RecursosNaoEcontradoExcessao(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setCelular(obj.getCelular());
		
	}
}
