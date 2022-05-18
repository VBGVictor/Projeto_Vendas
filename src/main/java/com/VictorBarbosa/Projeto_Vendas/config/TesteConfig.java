package com.VictorBarbosa.Projeto_Vendas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.VictorBarbosa.Projeto_Vendas.entities.Pedido;
import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.entities.enums.StatusPedido;
import com.VictorBarbosa.Projeto_Vendas.repositorios.PedidoRepositorio;
import com.VictorBarbosa.Projeto_Vendas.repositorios.UserRepositorio;

@Configuration
@Profile("test") //Servirá para popular o banco de dados com objetos
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Silva", "MariaSilva@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Antonio Marcos", "AntonioMarcos@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2022-05-17T23:23:30Z"), StatusPedido.PAGO, u1);//no Brasil é 3 horas atrasado do que no formato UTC
		Pedido p2 = new Pedido(null, Instant.parse("2022-05-18T12:23:30Z"), StatusPedido.ESPERANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2022-05-19T14:53:30Z"), StatusPedido.ESPERANDO_PAGAMENTO, u1);
		
		userRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
