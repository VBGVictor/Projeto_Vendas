package com.VictorBarbosa.Projeto_Vendas.servicos.exceptions;

public class BaseDadosExcessoes extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BaseDadosExcessoes(String msg) {
		super(msg);
	}

}
