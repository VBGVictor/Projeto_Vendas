package com.VictorBarbosa.Projeto_Vendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VictorBarbosa.Projeto_Vendas.entities.Categoria;
import com.VictorBarbosa.Projeto_Vendas.entities.User;


//Não há a necessidade de Anotação devida a herança feita abaixo, onde já é nomeada como Repositorio no Spring
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

	
	
}
