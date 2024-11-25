package br.sp.oz.portal.logistica.service.resources.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CategoriaProdutoDto{
	
	private int id;
	private String descricaoCategoria;

}
