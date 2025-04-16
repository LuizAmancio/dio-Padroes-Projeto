package com.estudoSpring.padroes_projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudoSpring.padroes_projeto.exception.BusinessExcpetion;
import com.estudoSpring.padroes_projeto.model.Cliente;
import com.estudoSpring.padroes_projeto.model.ClienteRepository;
import com.estudoSpring.padroes_projeto.model.EnderecoRepository;

/**
 * Implementação da stratgey {@link IClienteService}, a qual pode ser 
 * injetada pelo Spring (via {@link Autowired}. Com isso essa classe é um Service, 
 * ela será tratada como um <b>Singleton</b>
 */
@Service
public class ClienteService implements IClienteService {
	
	// Singleton: Injetar componentes do Spring com @Autowired
	// Strategy: Implementar os métodos definidos na interface
	// facade: abstrair integrações com subsistemas, provendo uma interface simples
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoService enderecoService;;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new BusinessExcpetion("Cliente não localizado"));
	}

	@Override
	public void inserir(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		cliente.setEndereco(enderecoService.buscarEnderecoByCep(cep));
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente clienteNovo) {
		Cliente clienteAntigo = buscarById(id);
		if(clienteAntigo != null) {
			clienteNovo.setId(id);
			String cep = clienteNovo.getEndereco().getCep();
			clienteNovo.setEndereco(enderecoService.buscarEnderecoByCep(cep));
			
			clienteRepository.save(clienteNovo);
			return;
		}
		
		throw new BusinessExcpetion("Cliente não localizado");
	}

	@Override
	public void deletar(Long id) {
		Cliente c = buscarById(id);
		if( c != null) {
			clienteRepository.delete(c);
			return;
		}
		throw new BusinessExcpetion("Cliente não localizado");
	}
}
