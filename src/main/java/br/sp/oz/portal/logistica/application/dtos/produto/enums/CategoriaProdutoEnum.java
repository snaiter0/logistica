package br.sp.oz.portal.logistica.application.dtos.produto.enums;

import lombok.*;

@AllArgsConstructor
@Getter
public enum CategoriaProdutoEnum {

    ALIMENTICIO(1,"ALIMENTICIO"),
    LIMPEZA(2,"LIMPEZA"),
    ELETRONICO(3,"ELETRONICO"),
    LATICINIO(4,"LATICINIO"),
    FARMACIA(5,"FARMACIA");

    private final int codigo;
    private final String descricao;

}
