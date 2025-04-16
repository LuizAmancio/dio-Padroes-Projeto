package com.estudoSpring.padroes_projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Atributos gerados automaticamente pelo site jsonschema2pojo.org, 
 * com base no Json de retorno da API ViaCEP
 * 
 * @see <a href="https://www.jsonchema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://viaCEP.com.br">ViaCEP</a>
 * 
 * @author Luiz Amancio
 */

@Getter
@Setter
@Entity
public class Endereco {

	@Id
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
}
