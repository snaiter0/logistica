package br.sp.oz.portal.logistica.adapters.in.controller.resources.response;

import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;

import java.util.Set;

public record InserirProdutosResponse(Set<ProdutoDto> produtos) {

}
