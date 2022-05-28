package com.VictorBarbosa.Projeto_Vendas.Recursos.excessoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.VictorBarbosa.Projeto_Vendas.servicos.exceptions.RecursosNaoEcontradoExcessao;

@ControllerAdvice
public class RecursoLidandoExcessoes {

	@ExceptionHandler(RecursosNaoEcontradoExcessao.class)       //Interceptará as excessões que acontecerem nesta classe escolhida e irá fazer o tratamento
	public ResponseEntity<StandardError> recursoNaoEncontrado(RecursosNaoEcontradoExcessao e, HttpServletRequest request){
		String error = "Recurso não Encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
