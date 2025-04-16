package com.estudoSpring.padroes_projeto.service;

import com.estudoSpring.padroes_projeto.model.Endereco;

public interface IEnderecoService {

	Endereco buscarEnderecoByCep(String cep);
}
