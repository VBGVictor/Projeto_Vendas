package com.VictorBarbosa.Projeto_Vendas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.repositorios.UserRepositorio;

@Configuration
@Profile("test") //Servirá para popular o banco de dados com objetos
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Silva", "MariaSilva@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Antonio Marcos", "AntonioMarcos@gmail.com", "977777777", "123456");
		
		userRepositorio.saveAll(Arrays.asList(u1, u2));
	}
	
}
