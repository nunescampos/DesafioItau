package com.desafioItau.Api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desafioItau.Api.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
