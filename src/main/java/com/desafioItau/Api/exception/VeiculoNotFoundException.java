package com.desafioItau.Api.exception;

public class VeiculoNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoNotFoundException(long id) {
        super("Veiculo nao encontrado: " + id);
    }
	
}
