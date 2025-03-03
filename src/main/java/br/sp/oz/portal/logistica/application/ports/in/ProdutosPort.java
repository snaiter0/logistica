package br.sp.oz.portal.logistica.application.ports.in;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import br.sp.oz.portal.logistica.domain.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.sp.oz.portal.logistica.adapters.in.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.adapters.in.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.application.dtos.produto.ExtratoProdutoDto;
import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;

public interface ProdutosPort {

	List<Produto> criarNovosProdutos(InserirProdutosRequest produtos);

	Produto atualizarProduto(AtualizarProdutosRequest attProdutos);

	Set<ProdutoDto> recuperarProdutos(LocalDate dataDiaUnico);

	Set<Produto> recuperarProdutos(LocalDateTime data);

	Page<ExtratoProdutoDto> recuperarProdutos(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable);

}
