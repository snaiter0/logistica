package br.sp.oz.portal.logistica.service.gateway.impl;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.sp.oz.portal.logistica.service.gateway.EmailGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailGatewayImpl implements EmailGateway {
	
	private final RestTemplate restTemplate;

	@Override
    public ResponseEntity<?> solicitarEnvioExtratoProdutos(FileSystemResource arquivoExtratoProdutos) {
        try {
        	
        	MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        	
        	body.add("arquivoExtrato", arquivoExtratoProdutos);
        	
            // Endpoint do seu servidor local
            String url = "http://localhost:8081/email-service/api/v1/email-anexo";
            
            // Headers para enviar como multipart/form-data
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            
            // Criar o corpo da requisição com o arquivo
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            
            // Realiza a requisição POST
            return restTemplate.exchange(url, HttpMethod.POST, requestEntity, HttpStatus.class);
        } catch (HttpClientErrorException e) {
        	throw new HttpClientErrorException(e.getStatusCode(), "Erro ao enviar solicitação de email: " + e.getMessage());
        } catch (Exception e) {
            throw e;
        }
    }
}
