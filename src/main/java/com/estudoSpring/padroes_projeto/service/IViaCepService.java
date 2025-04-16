package com.estudoSpring.padroes_projeto.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.estudoSpring.padroes_projeto.model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para consumo da API do
 * <b>ViaCEP</b>
 * 
 * @see <a href="https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/">Spring cloud Openfeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepService {
	
	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);

}
