package com.desafioItau.Api.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.desafioItau.Api.entity.Contrato;
import com.desafioItau.Api.entity.Veiculo;

public interface ContratoRepository extends MongoRepository<Contrato, String> {
	
	
  
}