package com.desafioItau.Api.controller;

import java.util.ArrayList;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioItau.Api.entity.Cliente;
import com.desafioItau.Api.entity.Contrato;
import com.desafioItau.Api.repository.ContratoRepository;
import com.desafioItau.Api.responses.Response;

import com.desafioItau.Api.exception.ContratoVencidoException;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;
	
	

	@GetMapping(path = "/")
	public ResponseEntity<Response<List<Contrato>>> listarTodosContratos() {
		
		return ResponseEntity.ok(new Response<List<Contrato>>(this.contratoRepository.findAll()));
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Contrato> listarPorId(@PathVariable(name = "id") long id) {
		
		return contratoRepository.findById(id);
	}

	
	@PutMapping(path = "/{numero}")
	 @ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<Response<Contrato>> cadastrar(@Valid @RequestBody Contrato contrato, String placa_veiculo, String valor_apolice, Date inicio_Vigencia, Date fim_Vigencia, BindingResult result) {
		
		
		contrato.setNumero(gerarApolice());
		
		if (verificavencimento(inicio_Vigencia,fim_Vigencia) == true) throw new ContratoVencidoException();
		
		if (result.hasErrors()) {
			
			List<String> erros = new ArrayList<String>();
		
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));

		      return ResponseEntity.badRequest().body(new Response(erros));
			
		}
		
		return ResponseEntity.ok(new Response<Contrato>(this.contratoRepository.save(contrato)));
	}
	@PutMapping(path = "/{id}")
public ResponseEntity<Response<Contrato>> atualizar(@PathVariable(name = "id") ObjectId id , @Valid @RequestBody Contrato contrato, Date inicio_Vigencia, Date fim_Vigencia, BindingResult result) {

		if (verificavencimento(inicio_Vigencia,fim_Vigencia) == true) throw new ContratoVencidoException();
		
		
		
		if (result.hasErrors()) {
			
			List<String> erros = new ArrayList<String>();
		
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));

		      return ResponseEntity.badRequest().body(new Response(erros));
			
		}
		
		//contrato.setId(id);
		
		return ResponseEntity.ok(new Response<Contrato>(this.contratoRepository.save(contrato)));
	}
	
	@PostMapping(value = "/{id}")
	public void deleteContrato(@PathVariable long id) {
		
		contratoRepository.deleteById(id);
	}
	
	
	
	private static float gerarApolice() {
		
		// geracao aleatorio de 0 a 1000
		
		Random aleatorio = new Random();
		float valor = aleatorio.nextFloat() * 1000;
		
		return valor;
			
	}
	
	public boolean verificavencimento(Date emissao, Date vencimento){
		
		// Informar se a apolice venceu ou nao a partir de um contrato
		
		boolean data;
		if (emissao.before(vencimento)){
			
			data = true;
		}
		else if (emissao.after(vencimento))
			data = false;
		else
			data = true;

		return data;
	}

	
		
}