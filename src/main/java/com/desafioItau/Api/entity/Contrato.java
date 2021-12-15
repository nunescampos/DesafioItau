package com.desafioItau.Api.entity;

import java.util.Date;


import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;



public class Contrato {
	
	@Id
	private long id;
	
	private float numero;
	
	private String placa_veiculo;
	
	private Date inicio_Vigencia;

	private Date fim_Vigencia;

	private String valor_apolice;

	
	@DBRef
	private Veiculo proposta;

	
	public Contrato() {
	}

	public Contrato(long id, float numero, String placa_veiculo, Date inicio_Vigencia, Date fim_Vigencia, String valor_apolice, Veiculo proposta) {
		this.id = id;
		this.numero = numero;
		this.placa_veiculo = placa_veiculo;
		this.inicio_Vigencia = inicio_Vigencia;
		this.fim_Vigencia = fim_Vigencia;
		this.valor_apolice = valor_apolice;
		this.proposta = proposta;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Veiculo getProposta() {
		return proposta;
	}

	public void setProposta(Veiculo proposta) {
		this.proposta = proposta;
	}

	
	@NotBlank(message = "Numero nao pode ser vazio")
	public float getNumero() {
		return numero;
	}

	public void setNumero(float numero) {
		this.numero = numero;
	}


	
	@NotBlank(message = "Placa nao pode ser vazio")
	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	@NotBlank(message = "Data inicio nao pode ser vazia")
	public Date getInicio_Vigencia() {
		return inicio_Vigencia;
	}

	public void setInicio_Vigencia(Date inicio_Vigencia) {
		this.inicio_Vigencia = inicio_Vigencia;
	}

	@NotBlank(message = "Data fim nao pode ser vazio")
	public Date getFim_Vigencia() {
		return fim_Vigencia;
	}

	public void setFim_Vigencia(Date fim_Vigencia) {
		this.fim_Vigencia = fim_Vigencia;
	}

	@NotBlank(message = "Valor da apolice nao pode ser vazio")
	public String getValor_apolice() {
		return valor_apolice;
	}

	public void setValor_apolice(String valor_apolice) {
		this.valor_apolice = valor_apolice;
	}




	
}