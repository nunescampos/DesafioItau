package com.desafioItau.Api.service.impl;

import java.util.List;

import javax.validation.Valid;

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

	@Override
	public List<Veiculo> listarTodosVeiculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo consultarVeiculoPeloID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> consultarVeiculosPelaMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> consultarVeiculosPeloAno(Integer ano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> consultarVeiculosPeloVendido(Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo cadastrar(@Valid String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo atualizar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo atualizarStatusVendido(Long id, Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
