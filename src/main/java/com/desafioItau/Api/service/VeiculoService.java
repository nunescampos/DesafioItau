package com.desafioItau.Api.service;

import java.util.List;

import com.desafioItau.Api.entity.Veiculo;

public interface VeiculoService {
	
	/*
	List<Veiculo> listarTodosVeiculo();
	
	Veiculo consultarVeiculoPeloID(Long id);
	
	List<Veiculo> consultarVeiculosPelaMarca(String marca);
	
	List<Veiculo> consultarVeiculosPeloAno(Integer ano);
	
	List<Veiculo> consultarVeiculosPeloVendido(Boolean status);
	
	Veiculo cadastrar(@Valid String id);
	
	Veiculo atualizar(Veiculo veiculo);
	
	Veiculo atualizarStatusVendido(Long id, Boolean status);
	
	void deletar(Long id);

*/
   public List<Veiculo> obterTodos();
	
	public Veiculo obterPorCodigo(long codigo);
	
	public Veiculo criar(Veiculo funcionario);


	
}