package com.desafioItau.Api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.desafioItau.Api.entity.Contrato;

public interface ContratoRepository extends MongoRepository<Contrato, String> {
  
}