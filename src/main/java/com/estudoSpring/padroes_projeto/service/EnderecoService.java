package com.estudoSpring.padroes_projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudoSpring.padroes_projeto.exception.BusinessExcpetion;
import com.estudoSpring.padroes_projeto.model.Endereco;
import com.estudoSpring.padroes_projeto.model.EnderecoRepository;

@Service
public class EnderecoService implements IEnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private IViaCepService viaCep;
	
	@Override
	public Endereco buscarEnderecoByCep(String cep) {
		return enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCep.consultarCep(cep);
			if(novoEndereco.getCep() != null) {
				return enderecoRepository.save(novoEndereco);				
			}
			throw new BusinessExcpetion("CEP não encontrado na base do viaCEP (https://viacep.com.br)");
		});
	}

}
