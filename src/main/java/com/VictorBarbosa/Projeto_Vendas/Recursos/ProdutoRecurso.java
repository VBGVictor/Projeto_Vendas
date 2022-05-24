package com.VictorBarbosa.Projeto_Vendas.Recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorBarbosa.Projeto_Vendas.entities.Produto;
import com.VictorBarbosa.Projeto_Vendas.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {

	@Autowired
	private ProdutoServico servico;//Dependencia
	
	
	@GetMapping  //Apenas para teste
	public ResponseEntity<List<Produto>> RetorneTodos(){
		
		List<Produto> list = servico.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
