package br.sp.oz.portal.logistica.service.resources.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.sp.oz.portal.logistica.service.resources.entitys.base.AuditedModelBase;
import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Entity
@Table(name = "produtos", schema = "dbo")
public class Produtos extends AuditedModelBase {

    @Column(name = "nome", nullable = false) // Nome não pode ser null em um produto
    private String nome;

    @Column(name = "dat_hora_entrada", nullable = true)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHoraEntrada;

    @Column(name = "dat_hora_saida", nullable = true)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHoraSaida;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "preco_compra", nullable = false)
    private Float precoCompra;

    @Column(name = "preco_medio", nullable = true)
    private Float precoMedio;

    @Column(name = "preco_venda", nullable = false)
    private Float precoVenda;

    @Column(name = "validade_lote_data", nullable = true)
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate validadeLoteData;

    @Column(name = "qtd_lote", nullable = false)
    private int qtdLote;
}
