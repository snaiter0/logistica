package br.sp.oz.portal.logistica.service.resources.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ProdutoDto {

	private String nome;
	
	private String descricao;
	
	private Float precoCompra;
	
	private Float precoMedio;
	
	private Float precoVenda;
	
	private LocalDate validadeLoteData;
	
	private CategoriaProdutoDto categoriaProduto;
	
	private int qtdLote;
	
	private Endereco destinatario ;
	
	private Endereco remetente;
	
	private LocalDateTime dataHoraEntrada;

	private LocalDateTime dataHoraSaida; 
}
