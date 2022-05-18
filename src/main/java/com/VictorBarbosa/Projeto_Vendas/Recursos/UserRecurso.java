package com.VictorBarbosa.Projeto_Vendas.Recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.servicos.UserServico;

@RestController
@RequestMapping(value = "/users")
public class UserRecurso {

	@Autowired
	private UserServico servico;//Dependencia
	
	
	@GetMapping  //Apenas para teste
	public ResponseEntity<List<User>> RetorneTodos(){
		
		List<User> list = servico.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
