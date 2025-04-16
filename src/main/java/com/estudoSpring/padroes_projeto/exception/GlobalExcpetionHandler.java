package com.estudoSpring.padroes_projeto.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExcpetionHandler extends ResponseEntityExceptionHandler {
	
	private HttpHeaders headers() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}
	
	private ResponseError responseError(String msg, HttpStatus status) {
		ResponseError response = new ResponseError();
		response.setStatusCode(status.value());
		response.setError(msg);
		return response;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGeneral(Exception e, WebRequest request){
		if(e instanceof BusinessExcpetion) {
			return handleBusinessException((BusinessExcpetion) e, request);
		}
		
		String message = "Erro interno no servidor. Por favor, tente novamente.";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
	}
	
	private ResponseEntity<Object> handleBusinessException(BusinessExcpetion e, WebRequest request){
		ResponseError error = responseError(e.getMessage(), HttpStatus.CONFLICT);
		return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
	}
}
