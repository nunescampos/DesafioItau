package com.desafioItau.Api.controller;

import java.util.ArrayList;

import java.util.List;

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

import java.util.*;

import com.desafioItau.Api.util.Optional;
import com.desafioItau.Api.exception.ClienteNotFoundException;
import com.desafioItau.Api.exception.ContratoVencidoException;
import com.desafioItau.Api.exception.CpfException;
import com.desafioItau.Api.exception.RenavamException;
import com.desafioItau.Api.exception.VeiculoNotFoundException;
import com.desafioItau.Api.entity.Cliente;
import com.desafioItau.Api.entity.Veiculo;
import com.desafioItau.Api.repository.ClienteRepository;
import com.desafioItau.Api.repository.VeiculoRepository;
import com.desafioItau.Api.responses.Response;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping(value = "/")
	public List<Veiculo> listarTodos() {

		return veiculoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Veiculo listarPorId(@PathVariable(name = "id") long id) {

		return veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNotFoundException(id)) ;
	}

	@PostMapping(value = "/")
	 @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Veiculo>> cadastrar(@Valid @RequestBody Veiculo veiculo, String renavam,
			BindingResult result) {

		if (validarRenavam(renavam) == true) throw new RenavamException(renavam);

			if (result.hasErrors()) {

				List<String> erros = new ArrayList<String>();

				result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));

				return ResponseEntity.badRequest().body(new Response(erros));

			}

		
		return ResponseEntity.ok(new Response<Veiculo>(this.veiculoRepository.save(veiculo)));
	}

	

	@PutMapping(path = "/{id}")
	public Veiculo cadastrarouatualizar(@PathVariable(name = "id") Long id,
			@Valid @RequestBody Veiculo veiculo, BindingResult result) {
		

		return veiculoRepository.findById(id)
                .map(x -> {
                    x.setNome(veiculo.getNome());
                    x.setAno(veiculo.getAno());
                    x.setMarca(veiculo.getMarca());
                    x.setDescricao(veiculo.getDescricao());
                    return veiculoRepository.save(x);
                })
                .orElseGet(() -> {
                	veiculo.setId(id);
                    return veiculoRepository.save(veiculo);
                });
	}

	@PostMapping(value = "/{id}")
	public void deleteVeiculo(@PathVariable Long id) {
		
		veiculoRepository.deleteById(id);
	}

	public boolean validarRenavam(String renavam){
		// Pegando como exemplo o renavam = 639884962

		// Completa com zeros a esquerda se for no padrao antigo de 9 digitos
		// renavam = 00639884962
		if(renavam.matches("^([0-9]{9})$")){
		renavam = "00" + renavam;
		}

		// Valida se possui 11 digitos pos formatacao
		if(!renavam.matches("[0-9]{11}")){
		return false;
		}

		// Remove o digito (11 posicao)
		// renavamSemDigito = 0063988496
		String renavamSemDigito = renavam.substring(0, 10);

		// Inverte os caracteres (reverso)
		// renavamReversoSemDigito = 69488936
		String renavamReversoSemDigito = new StringBuffer(renavamSemDigito).reverse().toString();

		int soma = 0;

		// Multiplica as strings reversas do renavam pelos numeros multiplicadores
		// para apenas os primeiros 8 digitos de um total de 10
		// Exemplo: renavam reverso sem digito = 69488936
		// 6, 9, 4, 8, 8, 9, 3, 6
		// * * * * * * * *
		// 2, 3, 4, 5, 6, 7, 8, 9 (numeros multiplicadores – sempre os mesmos [fixo])
		// 12 + 27 + 16 + 40 + 48 + 63 + 24 + 54
		// soma = 284
		for (int i = 0; i < 8; i++) {
		Integer algarismo = Integer.parseInt(renavamReversoSemDigito.substring(i, i + 1));
		Integer multiplicador = i + 2;
		soma += algarismo * multiplicador;
		}

		// Multiplica os dois ultimos digitos e soma
		soma += Character.getNumericValue(renavamReversoSemDigito.charAt(8)) * 2;
		soma += Character.getNumericValue(renavamReversoSemDigito.charAt(9)) * 3;

		// mod11 = 284 % 11 = 9 (resto da divisao por 11)
		int mod11 = soma % 11;

		// Faz-se a conta 11 (valor fixo) – mod11 = 11 – 9 = 2
		int ultimoDigitoCalculado = 11-mod11;

		// ultimoDigito = Caso o valor calculado anteriormente seja 10 ou 11, transformo ele em 0
		// caso contrario, eh o proprio numero
		ultimoDigitoCalculado = (ultimoDigitoCalculado >= 10 ? 0 : ultimoDigitoCalculado);

		// Pego o ultimo digito do renavam original (para confrontar com o calculado)
		int digitoRealInformado = Integer.valueOf(renavam.substring(renavam.length()-1, renavam.length()));

		// Comparo os digitos calculado e informado
		if(ultimoDigitoCalculado == digitoRealInformado){
		return true;
		}
		return false;
		}
		

	private static String retirarMascaraCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		return cpf;
	}

}