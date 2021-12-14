package com.desafioItau.Api.exception;

import org.bson.types.ObjectId;

public class ContratoNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContratoNotFoundException(ObjectId id) {
        super("Contrato nao encontrado : " + id);
    }

}