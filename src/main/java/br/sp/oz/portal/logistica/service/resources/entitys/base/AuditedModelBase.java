package br.sp.oz.portal.logistica.service.resources.entitys.base;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class AuditedModelBase extends ModelBase {

    @Column(name = "dat_insercao", updatable = false)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @CreatedDate
    protected LocalDateTime dataHoraInclusaoRegistro;

    @Column(name = "dat_hora_ult_modif_reg")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @LastModifiedDate
    protected LocalDateTime dataHoraUltimaModificacaoRegistro;

    @LastModifiedBy
    @Column(name = "usuario_ult_modif")
    protected String usuarioUltimaModificacao;
}
