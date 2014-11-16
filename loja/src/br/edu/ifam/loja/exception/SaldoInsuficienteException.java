package br.edu.ifam.loja.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public SaldoInsuficienteException(String msg) {
		
		super(msg);
	}
}
