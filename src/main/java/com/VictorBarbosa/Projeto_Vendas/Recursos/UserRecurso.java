package com.VictorBarbosa.Projeto_Vendas.Recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorBarbosa.Projeto_Vendas.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserRecurso {

	@GetMapping
	public ResponseEntity<User> RetorneTodos(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "9999999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
