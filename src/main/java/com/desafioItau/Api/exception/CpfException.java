package com.desafioItau.Api.exception;


public class CpfException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfException(String cpf) {
	        super("cpf ja existente : " + cpf);
	    }

}