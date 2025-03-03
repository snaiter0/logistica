package br.sp.oz.portal.logistica.domain.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProdutosException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProdutosException() {
		super();
	}
	public ProdutosException(String message) {
		super(message);
	}

	public ProdutosException(String message, Throwable cause) {
		super(message, cause);
	}
	public ProdutosException(Throwable cause) {
		super(cause);
	}
	
	protected ProdutosException(String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
