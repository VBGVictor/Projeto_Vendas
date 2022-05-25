package com.VictorBarbosa.Projeto_Vendas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.VictorBarbosa.Projeto_Vendas.entities.Categoria;
import com.VictorBarbosa.Projeto_Vendas.entities.Pedido;
import com.VictorBarbosa.Projeto_Vendas.entities.PedidoItem;
import com.VictorBarbosa.Projeto_Vendas.entities.Produto;
import com.VictorBarbosa.Projeto_Vendas.entities.User;
import com.VictorBarbosa.Projeto_Vendas.entities.enums.StatusPedido;
import com.VictorBarbosa.Projeto_Vendas.repositorios.CategoriaRepositorio;
import com.VictorBarbosa.Projeto_Vendas.repositorios.PedidoItemRepositorio;
import com.VictorBarbosa.Projeto_Vendas.repositorios.PedidoRepositorio;
import com.VictorBarbosa.Projeto_Vendas.repositorios.ProdutoRepositorio;
import com.VictorBarbosa.Projeto_Vendas.repositorios.UserRepositorio;

@Configuration
@Profile("test") //Servirá para popular o banco de dados com objetos
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepositorio userRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private PedidoItemRepositorio pedidoItemRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Silva", "MariaSilva@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Antonio Marcos", "AntonioMarcos@gmail.com", "977777777", "123456");
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		Pedido pe1 = new Pedido(null, Instant.parse("2022-05-17T23:23:30Z"), StatusPedido.PAGO, u1);//no Brasil é 3 horas atrasado do que no formato UTC
		Pedido pe2 = new Pedido(null, Instant.parse("2022-05-18T12:23:30Z"), StatusPedido.ESPERANDO_PAGAMENTO, u2);
		Pedido pe3 = new Pedido(null, Instant.parse("2022-05-19T14:53:30Z"), StatusPedido.ESPERANDO_PAGAMENTO, u1);
		
		userRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(pe1, pe2, pe3));
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		PedidoItem pi1 = new PedidoItem(pe1, p1, 2, p1.getPreco());
		PedidoItem pi2 = new PedidoItem(pe1, p3, 1, p3.getPreco());
		PedidoItem pi3 = new PedidoItem(pe2, p3, 2, p3.getPreco());
		PedidoItem pi4 = new PedidoItem(pe3, p5, 2, p5.getPreco());
		
		pedidoItemRepositorio.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));
	}
	
}
