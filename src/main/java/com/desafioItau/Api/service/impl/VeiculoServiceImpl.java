package com.desafioItau.Api.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Contrato;
import com.desafioItau.Api.entity.Veiculo;
import com.desafioItau.Api.repository.ContratoRepository;
import com.desafioItau.Api.repository.VeiculoRepository;
import com.desafioItau.Api.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private ContratoRepository contratoRepository;

	
	@Override
	public List<Veiculo> obterTodos() {
		return this.veiculoRepository.findAll();
	}

	@Override
	public Veiculo obterPorCodigo(String codigo) {
		return this.veiculoRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("veiculo não existe"));
	}

	@Override
	public Veiculo criar(Veiculo veiculo) {
		
		Contrato proposta = this.contratoRepository
				.findById(veiculo.getProposta().getId())
				.orElseThrow(() -> new IllegalArgumentException("proposta inexistente"));
	
		veiculo.setProposta(proposta);
	
		
		return this.veiculoRepository.save(veiculo);
	}

	
}
