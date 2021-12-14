package com.desafioItau.Api.service;

import java.util.List;


import com.desafioItau.Api.entity.Veiculo;
import com.desafioItau.Api.entity.dto.VeiculoRequestDto;

public interface VeiculoService {
	
	List<Veiculo> listarTodosVeiculo();
	
	Veiculo consultarVeiculoPeloID(Long id);
	
	List<Veiculo> consultarVeiculosPelaMarca(String marca);
	
	List<Veiculo> consultarVeiculosPeloAno(Integer ano);
	
	List<Veiculo> consultarVeiculosPeloVendido(Boolean status);
	
	Veiculo cadastrar(VeiculoRequestDto veiculo);
	
	Veiculo atualizar(VeiculoRequestDto veiculo);
	
	Veiculo atualizarStatusVendido(Long id, Boolean status);
	
	void deletar(Long id);
}