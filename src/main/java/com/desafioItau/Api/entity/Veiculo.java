package com.desafioItau.Api.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NonNull;

@Data
@Document
public class Veiculo {

	@Id
	private Long id;

	@NonNull
	private String nome;

	@NonNull
	private String marca;

	@NonNull
	private Integer ano;

	@NonNull
	private String descricao;

	private Boolean vendido = Boolean.FALSE;

	private LocalDate created = LocalDate.now();

	private LocalDate updated;

}