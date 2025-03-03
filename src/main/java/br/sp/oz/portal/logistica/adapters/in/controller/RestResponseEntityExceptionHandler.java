package br.sp.oz.portal.logistica.adapters.in.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Classe responsavel por personalizar a configuração de captura e lançamento de exceptions
 * padrões do servlet do Spring, a herança só é necessária no caso da necessidade de sobreescrita
 * do tratamento padrão, caso contrário o @ControllerAdvice poderia ser utilizado diretamente na
 * controller.
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


	/**
	 * Exemplo de configuracao personalizada do servlet para capturar exceptions ao receber possiveis requisicoes na interface REST
	 * 
	 * @param ex Exception capturada pela lista do @ExceptionHandler
	 * @param request requisição que gerou a exception.
	 * @return Response Entity padrão com msg e status personalizados de acordo com cara exception capturada pela anotacao @ExceptionHandler. 
	 */
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<>(montarResponse(
				"Falha ao receber parametros, verifique os dados fornecidos e seu devido formato."),
				new HttpHeaders(),
				HttpStatus.CONFLICT);
	}


	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class})
	protected ResponseEntity<Object> handleConflictTypeMismatchException(RuntimeException ex, WebRequest request) {

		Map<String, Object> parametrosAdicionais = new HashMap<>();
		parametrosAdicionais.put("parametros recebidos: ", request.getParameterMap());
		
		return new ResponseEntity<>(montarResponse(parametrosAdicionais,
				"Falha ao receber parametros, verifique os dados fornecidos e seu devido formato."),
				new HttpHeaders(),
				HttpStatus.CONFLICT);
	}

	private Map<String, Object> montarResponse(String mensagem){
		Map<String, Object> response = new HashMap<>();
		response.put("mensagem", mensagem);
		response.put("Horario", LocalDateTime.now());
		return response;
	}

	private Map<String, Object> montarResponse(Map<String, Object> entradasAdicionais, String mensagem){
		Map<String, Object> response = new HashMap<>();
		response.putAll(entradasAdicionais);
		response.put("mensagem", mensagem);
		response.put("horario", LocalDateTime.now());
		return response;
	}

}