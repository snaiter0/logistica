package br.sp.oz.portal.logistica.service.resources.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ExtratoProdutoDto {
	
	@NotBlank
	@Size(max = 300)
	private String nome;
	
	@Size(max = 2500)
	private String descricao;
	
	@NotBlank
	private Float precoCompra;
	
	@NotBlank
	private Float precoMedio;
	
	@NotBlank
	private Float precoVenda;
	
	@NotBlank
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate validadeLoteData;
	
	@Size(min = 1)
	private int qtdLote;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraEntrada;
	
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraSaida; 
}
