package com.desafioItau.Api.entity.dto;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class VeiculoRequestDto {
	
	private Long id;
	@NotNull @NotEmpty
	private String nome;
	private String descricao;
	@NotNull @NotEmpty
	private String marca;
	@NotNull
	private Integer ano;
	private Boolean vendido = Boolean.FALSE;

}