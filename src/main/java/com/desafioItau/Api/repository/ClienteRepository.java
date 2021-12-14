package com.desafioItau.Api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.desafioItau.Api.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

    List<Cliente> findAllById(String id);


}