package com.desafioItau.Api.exception;


public class ClienteNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNotFoundException(String id) {
        super("Cliente nao encontrado: " + id);
    }

}