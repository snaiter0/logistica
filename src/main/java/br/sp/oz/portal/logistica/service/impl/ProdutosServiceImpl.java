package br.sp.oz.portal.logistica.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private final PythonExecutor pyExec;
	
	
	private void converterDtosParaCsv(Set<?> produtosDto) {
		pyExec.executarConversaoCsv(produtosDto);
	}
	
	@Override
	public Set<Produtos> recuperarProdutos(LocalDateTime dataInicio, LocalDateTime dataFim){
		Set<Produtos> listaProdutos = recuperarListaProdutosPorJanelaData(dataInicio, dataFim);
		converterDtosParaCsv(produtoMapper.produtosToProdutosDto(listaProdutos));
		return listaProdutos;
	}
	
	@Override
	public Set<Produtos> recuperarProdutos(LocalDate dataDiaUnico){
		return recuperarListaProdutosPorDia(dataDiaUnico);
	}
	
	@Override
	public Set<Produtos> recuperarProdutos(LocalDateTime data){
		return recuperarExtratoProdutosPorData(data);
	}
	
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
	
	@Transactional
	private Set<Produtos> recuperarExtratoProdutosPorData(LocalDateTime dataPesquisaProdutos) {
		return produtosRepository.recuperarListaProdutosPorDataUnica(dataPesquisaProdutos);
	}
	
	@Transactional
	private Set<Produtos> recuperarListaProdutosPorJanelaData(LocalDateTime dataPesquisaProdutosInicio,LocalDateTime dataPesquisaProdutosFim ){
		return produtosRepository.recuperarListaProdutosPorJanelaData(dataPesquisaProdutosInicio, dataPesquisaProdutosFim);
	}
	
	@Transactional
	private Set<Produtos> recuperarListaProdutosPorDia(LocalDate dataPesquisaProdutos){
		return produtosRepository.recuperarListaProdutosPorDiaUnico(dataPesquisaProdutos.atStartOfDay(), dataPesquisaProdutos.plusDays(1).atStartOfDay());
	}
}
