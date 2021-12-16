package com.desafioItau.Api.service;

import java.util.List;

import com.desafioItau.Api.entity.Produto;

public interface ProdutoService {

public List<Produto> obterTodos();
	
	public Produto obterPorCodigo(String codigo);
	
	public Produto criar(Produto contrato);
	
	
}
