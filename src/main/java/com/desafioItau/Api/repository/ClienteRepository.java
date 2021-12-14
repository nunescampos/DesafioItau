package com.desafioItau.Api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.desafioItau.Api.entity.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

	Object findAll(String id);


}