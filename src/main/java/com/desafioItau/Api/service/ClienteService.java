package com.desafioItau.Api.service;

import java.util.*;



import com.desafioItau.Api.entity.Cliente;

public interface ClienteService {

	public List<Cliente> obterTodos();
	
	public Cliente obterPorCodigo(long codigo);
	
	public Cliente criar(Cliente funcionario);
}
