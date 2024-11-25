package br.sp.oz.portal.logistica.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.sp.oz.portal.logistica.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.service.LogisticaService;
import br.sp.oz.portal.logistica.service.exceptions.ProdutosNotFoundException;
import br.sp.oz.portal.logistica.service.repositories.ProdutosRepository;
import br.sp.oz.portal.logistica.service.resources.dtos.ProdutoDto;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;
import br.sp.oz.portal.logistica.service.resources.mappers.ProdutoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutosServiceImpl implements LogisticaService {

	private final ProdutoMapper produtoMapper;
	private final ProdutosRepository produtosRepository;
	
	@Override
	public List<Produtos> criarNovosProdutos(InserirProdutosRequest produtos) {
		Set<Produtos> produtosEntity = new HashSet<Produtos>();
		for(ProdutoDto produto : produtos.getProdutos()) {
			produtosEntity.add(produtoMapper.produtoDtoToProduto(produto));
		}
		
		return produtosRepository.saveAll(produtosEntity);
	}
	
	@Override
	public Produtos atualizarProduto(AtualizarProdutosRequest attProdutos) {
		Produtos produto = recuperarProdutoPorId(attProdutos.getIdProduto());
		Produtos produtoAtualizado = produtoMapper.produtoDtoToProduto(attProdutos.getProduto());
		produtoAtualizado.setId(produto.getId());
		return produtosRepository.saveAndFlush(produtoAtualizado);
	}
	
	
	@Transactional
	private Produtos recuperarProdutoPorId(Long idProduto) {
		return produtosRepository.findById(idProduto).orElseThrow(ProdutosNotFoundException::new);
	}
}
