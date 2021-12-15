package com.desafioItau.Api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Cliente;
import com.desafioItau.Api.entity.Contrato;
import com.desafioItau.Api.entity.Veiculo;
import com.desafioItau.Api.repository.ClienteRepository;
import com.desafioItau.Api.repository.ContratoRepository;
import com.desafioItau.Api.repository.VeiculoRepository;
import com.desafioItau.Api.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public List<Contrato> obterTodos() {
		return this.contratoRepository.findAll();
	}

	@Override
	public Contrato obterPorCodigo(long codigo) {
		return this.contratoRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("contrato não existe"));
	}

	@Override
	public Contrato criar(Contrato contrato) {
		
		
		
		return this.contratoRepository.save(contrato);
	}

}