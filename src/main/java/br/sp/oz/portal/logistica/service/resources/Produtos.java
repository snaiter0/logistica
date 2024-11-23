package br.sp.oz.portal.logistica.service.resources;
	

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Produtos extends AbstractAuditedModelBase{
	
	@Column(name = "nome_produto", nullable = true)
	private String nomeProduto;
	
	@Column(name = "dat_hora_entrada", nullable = true)
	private LocalDateTime dataHoraEntrada;

	@Column(name = "dat_hora_saida", nullable = true)
	private LocalDateTime dataHoraSaida; 
}
