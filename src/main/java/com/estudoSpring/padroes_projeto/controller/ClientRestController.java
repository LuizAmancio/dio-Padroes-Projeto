package com.estudoSpring.padroes_projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudoSpring.padroes_projeto.model.Cliente;
import com.estudoSpring.padroes_projeto.service.ClienteService;

/**
 * Representa nossa FACADE, pois abstrai toda a complexidade 
 * de integrações(Banco H2 e API do viaCEP em uma interface 
 * simples e coesa (API REST)
 */
@RestController
@RequestMapping("clientes")
public class ClientRestController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarById(@PathVariable("id") Long id){
		return ResponseEntity.ok(clienteService.buscarById(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente){
		clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
}
