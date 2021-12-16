package com.desafioItau.Api.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioItau.Api.entity.Contrato;
import com.desafioItau.Api.entity.Produto;
import com.desafioItau.Api.repository.ContratoRepository;
import com.desafioItau.Api.repository.ProdutoRepository;
import com.desafioItau.Api.service.ContratoService;
import com.desafioItau.Api.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public List<Produto> obterTodos() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto obterPorCodigo(String codigo) {
		return this.produtoRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("produto não existe"));
	}

	@Override
	public Produto criar(Produto produto) {
		
		
		
		return this.produtoRepository.save(produto);
	}

}