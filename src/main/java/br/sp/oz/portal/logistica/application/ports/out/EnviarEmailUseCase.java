package br.sp.oz.portal.logistica.application.ports.out;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

public interface EnviarEmailUseCase {

	/**
	 * TODO: Implementar uso com retorno da API de envio de email, talvez com statusCode ou coisa do genero.
	 *
	 * @param arquivoExtratoProdutos
	 * @return
	 */
	ResponseEntity<?> solicitarEnvioExtratoProdutos(FileSystemResource arquivoExtratoProdutos);

}
