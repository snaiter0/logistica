package br.sp.oz.portal.logistica.service.resources.entitys;
	

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.sp.oz.portal.logistica.service.resources.entitys.base.AbstractAuditedModelBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
@Data

@Table(name = "produto", schema = "dbo")
@Entity
public class Produtos extends AbstractAuditedModelBase{
	
	@Column(name = "nome", nullable = true)
	private String nome;
	
	@Column(name = "dat_hora_entrada", nullable = true)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraEntrada;

	@Column(name = "dat_hora_saida", nullable = true)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraSaida; 
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco_compra")
	private Float precoCompra;
	
	@Column(name = "preco_medio")
	private Float precoMedio;
	
	@Column(name = "preco_venda")
	private Float precoVenda;
	
	@Column(name = "validade_lote_data")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate validadeLoteData;
	
	//@Column(name = "categoria")
	// private CategoriaProdutoDto categoriaProduto;
	
	@Column(name = "qtd_lote")
	private int qtdLote;
	
	//@Column(name = "destinatario")
	//private Endereco destinatario;
	
	//@Column(name = "remetente")
	//private Endereco remetente;
}
