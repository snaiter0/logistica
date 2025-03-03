package br.sp.oz.portal.logistica.domain.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProdutosNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProdutosNotFoundException() {
		super();
	}
	public ProdutosNotFoundException(String message) {
		super(message);
	}

	public ProdutosNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ProdutosNotFoundException(Throwable cause) {
		super(cause);
	}
	
	protected ProdutosNotFoundException(String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
