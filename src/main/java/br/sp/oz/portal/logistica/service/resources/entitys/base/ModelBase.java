package br.sp.oz.portal.logistica.service.resources.entitys.base;

import jakarta.persistence.*;
import lombok.*;

@Data
@MappedSuperclass
public class ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected Long id; 
}