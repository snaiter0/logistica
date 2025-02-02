package br.sp.oz.portal.logistica.service.gateway;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

public interface EmailGateway {

	ResponseEntity<?> solicitarEnvioExtratoProdutos(FileSystemResource arquivoExtratoProdutos);

}
