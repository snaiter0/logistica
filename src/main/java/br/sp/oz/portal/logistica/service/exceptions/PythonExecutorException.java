package br.sp.oz.portal.logistica.service.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PythonExecutorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PythonExecutorException() {
		super();
	}
	public PythonExecutorException(String message) {
		super(message);
	}

	public PythonExecutorException(String message, Throwable cause) {
		super(message, cause);
	}
	public PythonExecutorException(Throwable cause) {
		super(cause);
	}
	
	protected PythonExecutorException(String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
