package br.sp.oz.portal.logistica.controller.resources.request;

import java.util.Set;

import br.sp.oz.portal.logistica.service.resources.dtos.ProdutoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InserirProdutosRequest {
	
	private Set<ProdutoDto> produtos;
}
