package br.sp.oz.portal.logistica.service;

import br.sp.oz.portal.logistica.controller.resources.request.ProdutosDto;
import br.sp.oz.portal.logistica.service.resources.Produtos;

public interface LogisticaService {

	Produtos criarNovoProduto(ProdutosDto produtos);

	Produtos atualizarProduto();

}
