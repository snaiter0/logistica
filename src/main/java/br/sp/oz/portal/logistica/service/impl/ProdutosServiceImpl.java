package br.sp.oz.portal.logistica.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import br.sp.oz.portal.logistica.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.service.LogisticaService;
import br.sp.oz.portal.logistica.service.exceptions.ProdutosNotFoundException;
import br.sp.oz.portal.logistica.service.gateway.EmailGateway;
import br.sp.oz.portal.logistica.service.impl.utils.PythonExecutor;
import br.sp.oz.portal.logistica.service.repositories.ProdutosRepository;
import br.sp.oz.portal.logistica.service.resources.dtos.ExtratoProdutoDto;
import br.sp.oz.portal.logistica.service.resources.dtos.ProdutoDto;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;
import br.sp.oz.portal.logistica.service.resources.mappers.ProdutoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutosServiceImpl implements LogisticaService {

	private final ProdutoMapper produtoMapper;
	private final EmailGateway emailGateway;
	private final ProdutosRepository produtosRepository;
	
	private FileSystemResource converterDtosParaCsv(Set<?> produtosDto) {
		return PythonExecutor.executarConversaoCsv(produtosDto);
	}
	
	@Override
	public Set<ExtratoProdutoDto> recuperarProdutos(LocalDateTime dataInicio, LocalDateTime dataFim){
		Set<ExtratoProdutoDto> listaProdutosDto = produtoMapper.produtosToExtratoProdutosDto(recuperarListaProdutosPorJanelaData(dataInicio, dataFim));
		emailGateway.solicitarEnvioExtratoProdutos(converterDtosParaCsv(listaProdutosDto));
		return listaProdutosDto;
	}
	
	@Override
	public Set<ProdutoDto> recuperarProdutos(LocalDate dataDiaUnico){
		Set<ProdutoDto> listaProdutosDto = produtoMapper.produtosToProdutosDto(recuperarListaProdutosPorDia(dataDiaUnico));
			
		return listaProdutosDto;
	}
	
	@Override
	public Set<Produtos> recuperarProdutos(LocalDateTime data){
		return recuperarExtratoProdutosPorData(data);
	}
	
	@Override
	public List<Produtos> criarNovosProdutos(InserirProdutosRequest produtos) {
        Set<Produtos> produtosEntity = new HashSet<>();
        for (ProdutoDto produto : produtos.getProdutos()) {
            produtosEntity.add(produtoMapper.produtoDtoToProduto(produto));
        }

        List<Produtos> produtosSalvos = salvarProdutos(produtosEntity);

        return produtosSalvos;
    }
	
	@Transactional
	private List<Produtos> salvarProdutos(Set<Produtos> produtosEntity) {
		return produtosRepository.saveAll(produtosEntity);
	}
	
	@Override
	public Produtos atualizarProduto(AtualizarProdutosRequest attProdutos) {
		Produtos produto = recuperarProdutoPorId(attProdutos.getIdProduto());
		Produtos produtoAtualizado = produtoMapper.produtoDtoToProduto(attProdutos.getProduto());
		produtoAtualizado.setId(produto.getId());
		return produtosRepository.saveAndFlush(produtoAtualizado);
	}
	
	
	private Produtos recuperarProdutoPorId(Long idProduto) {
		return produtosRepository.findById(idProduto)
				.orElseThrow(ProdutosNotFoundException::new);
	}


	private Set<Produtos> recuperarExtratoProdutosPorData(LocalDateTime dataPesquisaProdutos) {
		return produtosRepository.recuperarListaProdutosPorDataUnica(dataPesquisaProdutos);
	}


	private Set<Produtos> recuperarListaProdutosPorJanelaData(LocalDateTime dataPesquisaProdutosInicio,LocalDateTime dataPesquisaProdutosFim ){
		return produtosRepository.recuperarListaProdutosPorJanelaData(dataPesquisaProdutosInicio, dataPesquisaProdutosFim);
	}


	private Set<Produtos> recuperarListaProdutosPorDia(LocalDate dataPesquisaProdutos){
		return produtosRepository.recuperarListaProdutosPorDiaUnico(dataPesquisaProdutos.atStartOfDay(), dataPesquisaProdutos.plusDays(1).atStartOfDay());
	}
}
