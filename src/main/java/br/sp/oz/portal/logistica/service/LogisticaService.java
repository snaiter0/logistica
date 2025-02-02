package br.sp.oz.portal.logistica.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import br.sp.oz.portal.logistica.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.service.resources.dtos.ExtratoProdutoDto;
import br.sp.oz.portal.logistica.service.resources.dtos.ProdutoDto;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;

public interface LogisticaService {

	List<Produtos> criarNovosProdutos(InserirProdutosRequest produtos);

	Produtos atualizarProduto(AtualizarProdutosRequest attProdutos);

	Set<ExtratoProdutoDto> recuperarProdutos(LocalDateTime dataInicio, LocalDateTime dataFim);

	Set<ProdutoDto> recuperarProdutos(LocalDate dataDiaUnico);

	Set<Produtos> recuperarProdutos(LocalDateTime data);

}
