package com.VictorBarbosa.Projeto_Vendas.Recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorBarbosa.Projeto_Vendas.entities.Categoria;
import com.VictorBarbosa.Projeto_Vendas.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {

	@Autowired
	private CategoriaServico servico;//Dependencia
	
	
	@GetMapping  //Apenas para teste
	public ResponseEntity<List<Categoria>> RetorneTodos(){
		
		List<Categoria> list = servico.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
