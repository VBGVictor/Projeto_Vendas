package com.VictorBarbosa.Projeto_Vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VictorBarbosa.Projeto_Vendas.entities.User;

public interface UserRepositorio extends JpaRepository<User, Long> {

	
	
}
