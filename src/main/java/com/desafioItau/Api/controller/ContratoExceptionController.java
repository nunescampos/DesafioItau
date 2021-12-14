package com.desafioItau.Api.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.desafioItau.Api.Exception.ContratoVencidoException;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContratoExceptionController {
	@ExceptionHandler(value = ContratoVencidoException.class)
	public ResponseEntity<Object> exception(ContratoVencidoException exception) {
		return new ResponseEntity<>("Apolice vencido ", HttpStatus.NOT_ACCEPTABLE);
	}
}