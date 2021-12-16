package com.desafioItau.Api.exception;

public class VeiculoNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoNotFoundException(String id) {
        super("Veiculo nao encontrado: " + id);
    }
	
}
