package br.sp.oz.portal.logistica.application.dtos.produto;

import br.sp.oz.portal.logistica.application.dtos.produto.enums.CategoriaProdutoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record ProdutoDto(String nome,
						 String descricao,
						 Float precoCompra,
						 Float precoMedio,
						 Float precoVenda,
						 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
						 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
						 LocalDate validadeLoteData,
						 CategoriaProdutoEnum categoriaProduto,
						 int qtdLote,
						 EnderecoDto destinatario,
						 EnderecoDto remetente,
						 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
						 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
						 LocalDateTime dataHoraEntrada,
						 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
						 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
						 LocalDateTime dataHoraSaida) {
}
