package com.desafioItau.Api.repository;

import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafioItau.Api.entity.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
	
}