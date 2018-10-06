package br.com.murilo.ecommercepuc.service;

/**
 * Classe de exceção para operações com cliente
 * @author murilocosta
 */
public class CustomerServiceException extends Exception {	
	
	private static final long serialVersionUID = 1L;

	public CustomerServiceException(String message) {
		super(message);
	}

}
