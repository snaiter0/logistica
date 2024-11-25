package br.sp.oz.portal.logistica.service;

import java.util.List;

import br.sp.oz.portal.logistica.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;

public interface LogisticaService {

	List<Produtos> criarNovosProdutos(InserirProdutosRequest produtos);

	Produtos atualizarProduto(AtualizarProdutosRequest attProdutos);

}
