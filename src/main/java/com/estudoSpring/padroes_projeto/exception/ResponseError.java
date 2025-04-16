package com.estudoSpring.padroes_projeto.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError {
	private final Date timestamp = new Date();
	private final String status = "error";
	private int statusCode = 400;
	
	private String error;
}
