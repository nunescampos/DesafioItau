package com.desafioItau.Api.service;

import java.util.List;

import com.desafioItau.Api.entity.Contrato;

public interface ContratoService {
	
public List<Contrato> obterTodos();
	
	public Contrato obterPorCodigo(String codigo);
	
	public Contrato criar(Contrato contrato);
	

}
