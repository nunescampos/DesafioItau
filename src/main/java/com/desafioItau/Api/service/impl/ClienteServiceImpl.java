package com.desafioItau.Api.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Cliente;
import com.desafioItau.Api.entity.Veiculo;
import com.desafioItau.Api.repository.ClienteRepository;
import com.desafioItau.Api.repository.VeiculoRepository;
import com.desafioItau.Api.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
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
		
		Veiculo veiculo = this.veiculoRepository
				.findById(cliente.getRenavam().getId())
				.orElseThrow(() -> new IllegalArgumentException("veiculo inexistente"));
	
		  cliente.setRenavam(veiculo);
	
		
		return this.clienteRepository.save(cliente);
	}

}
