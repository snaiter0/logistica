package br.sp.oz.portal.logistica.adapters.in.controller.resources.request;

import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;


public record AtualizarProdutosRequest(ProdutoDto produto, Long idProduto) {

}
 