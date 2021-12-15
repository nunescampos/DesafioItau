package com.desafioItau.Api.entity;

import javax.validation.constraints.Email;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cliente {

	@Id
	private long id;
	
	@NotBlank(message = "Nome nao pode ser vazio")
	private String nome;

	@NotEmpty(message = "Email nao pode ser vazio")
	@Email(message = "Email invalido")
	private String email;

	@NotEmpty(message = "Cpf nao pode ser vazio")
	private Long cpf;

	@NotBlank(message = "Cidade nao pode ser vazio")
	private String cidade;

	@NotBlank(message = "Uf nao pode ser vazio")
	private String uf;

	@DBRef
	private Veiculo renavam;


	
	public Cliente() {
	}

	public Cliente(long id, String nome, String email, Long cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return id + "::" + nome + "::" + email + "::" + cpf + "::" + cidade + "::" + uf + "::";
	}

	


}