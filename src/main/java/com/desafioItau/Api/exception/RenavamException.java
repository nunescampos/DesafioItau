package com.desafioItau.Api.exception;

public class RenavamException extends RuntimeException{
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public RenavamException(String renavam) {
		        super("cpf ja existente : " + renavam);
		    }
	
}
	

