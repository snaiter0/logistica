package br.sp.oz.portal.logistica.controller.resources.request;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProdutosDto {
	
	private LocalDateTime dataHoraEntrada;

	private LocalDateTime dataHoraSaida; 
}
