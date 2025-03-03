package br.sp.oz.portal.logistica.infrastructure.gateway;

import br.sp.oz.portal.logistica.application.ports.out.EnviarEmailUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
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

import lombok.RequiredArgsConstructor;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailRestGateway implements EnviarEmailUseCase {


    //@Value("${rabbitmq.exchange.name}") 
    private String exchangeName;
	
	private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

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

            log.info("Pedido enfileirado: {}", requestEntity.toString());

            // Realiza a requisição POST
            return restTemplate.exchange(url, HttpMethod.POST, requestEntity, HttpStatus.class);
        } catch (HttpClientErrorException e) {
        	throw new HttpClientErrorException(e.getStatusCode(), "Erro ao enviar solicitação de email: " + e.getMessage());
        }
    }
}
