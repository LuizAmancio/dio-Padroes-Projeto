package com.estudoSpring.padroes_projeto.service;

import com.estudoSpring.padroes_projeto.model.Cliente;

/**
 * Inteface que define o padrão strategy no domínio do cliente.
 * Podemos ter multiplas implementações dessa mesma interface
 */
public interface IClienteService {

	Iterable<Cliente> buscarTodos();
	
	Cliente buscarById(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);
}
