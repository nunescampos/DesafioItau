package com.desafioItau.Api.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafioItau.Api.entity.Veiculo;


@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, Long> {

	List<Veiculo> findAllByMarca(String marca);
	
	List<Veiculo> findAllByAno(Integer ano);
	
	List<Veiculo> findAllByVendido(Boolean status);
	
}