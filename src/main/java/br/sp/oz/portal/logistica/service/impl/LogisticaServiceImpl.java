package br.sp.oz.portal.logistica.service.impl;

import org.springframework.stereotype.Service;

import br.sp.oz.portal.logistica.controller.resources.request.ProdutosDto;
import br.sp.oz.portal.logistica.service.LogisticaService;
import br.sp.oz.portal.logistica.service.resources.Produtos;
import br.sp.oz.portal.logistica.service.resources.entitys.ProdutosRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogisticaServiceImpl implements LogisticaService {

	private final ProdutosRepository produtosRepository;
	
	@Override
	public Produtos criarNovoProduto(ProdutosDto produtos) {
		return produtosRepository.save(new Produtos());
	}
	
	@Override
	public Produtos atualizarProduto() {
		
		Produtos produto = produtosRepository.findAll().getFirst();
		produto.setNomeProduto("Pasta de dente");
		return produtosRepository.saveAndFlush(produto);
			
	}
	
}
