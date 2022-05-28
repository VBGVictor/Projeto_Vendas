package com.VictorBarbosa.Projeto_Vendas.servicos.exceptions;

public class RecursosNaoEcontradoExcessao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursosNaoEcontradoExcessao(Object id) {
		super("Recurso não encontrado. Id " + id);
	}
	
	
}
