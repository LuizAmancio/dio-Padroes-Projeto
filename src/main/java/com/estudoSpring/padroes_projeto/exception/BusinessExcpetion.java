package com.estudoSpring.padroes_projeto.exception;

public class BusinessExcpetion extends RuntimeException {
	
	public BusinessExcpetion(String mensagem) {
		super(mensagem);
	}
	public BusinessExcpetion(String mensagem, Object ... params) {
		super(String.format(mensagem, params));
	}
}
