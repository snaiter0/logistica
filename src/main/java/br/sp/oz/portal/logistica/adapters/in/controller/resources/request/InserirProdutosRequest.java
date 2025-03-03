package br.sp.oz.portal.logistica.adapters.in.controller.resources.request;

import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;

import java.util.Set;

public record InserirProdutosRequest(Set<ProdutoDto> produtos) {
}
