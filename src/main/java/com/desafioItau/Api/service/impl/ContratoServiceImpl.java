package com.desafioItau.Api.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Contrato;
import com.desafioItau.Api.repository.ContratoRepository;
import com.desafioItau.Api.repository.ProdutoRepository;
import com.desafioItau.Api.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public List<Contrato> obterTodos() {
		return this.contratoRepository.findAll();
	}

	@Override
	public Contrato obterPorCodigo(String codigo) {
		return this.contratoRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("contrato n�o existe"));
	}

	@Override
	public Contrato criar(Contrato contrato) {
		
		
		
		return this.contratoRepository.save(contrato);
	}

}