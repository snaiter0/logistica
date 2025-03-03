package br.sp.oz.portal.logistica.application.dtos.produto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ExtratoProdutoDto(String nome,
								String descricao,
								Float precoCompra,
								Float precoMedio,
								Float precoVenda,
								@DateTimeFormat(iso = ISO.DATE)
								@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
								LocalDate validadeLoteData,
								int qtdLote,
								@DateTimeFormat(iso = ISO.DATE_TIME)
								@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
								LocalDateTime dataHoraEntrada,
								@DateTimeFormat(iso = ISO.DATE_TIME)
								@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
								LocalDateTime dataHoraSaida) {
}
