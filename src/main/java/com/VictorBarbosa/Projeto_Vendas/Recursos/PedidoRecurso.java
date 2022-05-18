package com.VictorBarbosa.Projeto_Vendas.Recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VictorBarbosa.Projeto_Vendas.entities.Pedido;
import com.VictorBarbosa.Projeto_Vendas.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {

	@Autowired
	private PedidoServico servico;//Dependencia
	
	
	@GetMapping  //Apenas para teste
	public ResponseEntity<List<Pedido>> RetorneTodos(){
		
		List<Pedido> list = servico.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
