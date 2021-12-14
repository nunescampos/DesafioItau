package com.desafioItau.Api.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Cliente;
import com.desafioItau.Api.repository.ClienteRepository;
import com.desafioItau.Api.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> obterTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente obterPorCodigo(String codigo) {
		return this.clienteRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("cliente não existe"));
	}

	@Override
	public Cliente criar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

}
