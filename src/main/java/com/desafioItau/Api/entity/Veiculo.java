package com.desafioItau.Api.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NonNull;

@Data
@Document
public class Veiculo {

	@Id
	private String id;

	@NonNull
	private String nome;

	@NonNull
	private String marca;

	@NonNull
	private Integer ano;

	@NonNull
	private String descricao;
	
	@NonNull
	private int valor = 0;
	
	@NonNull
	private int valorEntrada = 0;
	
	@NonNull
	private int numPrestacoes = 0;
	
	@NonNull
	private double taxaJuros = 0;

	@NonNull
	private double valorPrestacao = 0;

	@DBRef
	private Veiculo renavam;

		
	private Boolean vendido = Boolean.FALSE;

	private LocalDate created = LocalDate.now();

	private LocalDate updated;

	@DBRef
	private Contrato proposta;

	}