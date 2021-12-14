package com.desafioItau.Api.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Veiculo;
import com.desafioItau.Api.repository.VeiculoRepository;
import com.desafioItau.Api.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public List<Veiculo> obterTodos() {
		return this.veiculoRepository.findAll();
	}

	@Override
	public Veiculo obterPorCodigo(long codigo) {
		return this.veiculoRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("veiculo não existe"));
	}

	@Override
	public Veiculo criar(Veiculo veiculo) {
		return this.veiculoRepository.save(veiculo);
	}

	
}
