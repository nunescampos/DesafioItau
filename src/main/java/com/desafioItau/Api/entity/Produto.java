package com.desafioItau.Api.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Produto {
	
	private String id;
	
	private float numero;
	
	private String placa_veiculo;
	
	private Date inicio_Vigencia;

	private Date fim_Vigencia;

	private String valor_apolice;

	
	@DBRef
	private Veiculo proposta;

	
	public Produto() {
	}

	public Produto(String id, float numero, String placa_veiculo, Date inicio_Vigencia, Date fim_Vigencia, String valor_apolice, Veiculo proposta) {
		this.id = id;
		this.numero = numero;
		this.placa_veiculo = placa_veiculo;
		this.inicio_Vigencia = inicio_Vigencia;
		this.fim_Vigencia = fim_Vigencia;
		this.valor_apolice = valor_apolice;
		this.proposta = proposta;
	}
	
	
}