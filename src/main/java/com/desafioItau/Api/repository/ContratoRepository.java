package com.desafioItau.Api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.desafioItau.Api.Entity.Contrato;

public interface ContratoRepository extends MongoRepository<Contrato, String> {
  
}