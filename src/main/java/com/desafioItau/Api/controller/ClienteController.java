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
import com.desafioItau.Api.entity.Cliente;
import com.desafioItau.Api.repository.ClienteRepository;
import com.desafioItau.Api.responses.Response;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(value = "/")
	public List<Cliente> listarTodos() {

		return clienteRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Cliente listarPorId(@PathVariable(name = "id") String id) {

		return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id)) ;
	}

	@PostMapping(value = "/")
	 @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, String cpf,
			BindingResult result) {

		if (validacaoCpf(cpf) == true) throw new CpfException(cpf);

			if (result.hasErrors()) {

				List<String> erros = new ArrayList<String>();

				result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));

				return ResponseEntity.badRequest().body(new Response(erros));

			}

		
		return ResponseEntity.ok(new Response<Cliente>(this.clienteRepository.save(cliente)));
	}

	

	@PutMapping(path = "/{id}")
	public Cliente cadastrarouatualizar(@PathVariable(name = "id") String id,
			@Valid @RequestBody Cliente cliente, BindingResult result) {
		

		return clienteRepository.findById(id)
                .map(x -> {
                    x.setNome(cliente.getNome());
                    x.setCpf(cliente.getCpf());
                    x.setCidade(cliente.getCidade());
                    x.setUf(cliente.getUf());
                    x.setEmail(cliente.getEmail());
                    return clienteRepository.save(x);
                })
                .orElseGet(() -> {
                    cliente.setId(id);
                    return clienteRepository.save(cliente);
                });
	}

	@PostMapping(value = "/{id}")
	public void deleteCliente(@PathVariable String id) {
		
		clienteRepository.deleteById(id);
	}

	public static boolean validacaoCpf(String cpfModel) {
		String cpf = retirarMascaraCpf(cpfModel);
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

			d1 = d1 + (11 - nCount) * digitoCPF;

			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		resto = (d1 % 11);

		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		resto = (d2 % 11);

		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		return nDigVerific.equals(nDigResult);
	}

	private static String retirarMascaraCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		return cpf;
	}

}