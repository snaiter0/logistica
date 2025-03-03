package br.sp.oz.portal.logistica.application.service;

import br.sp.oz.portal.logistica.adapters.in.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.adapters.in.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.application.dtos.produto.ExtratoProdutoDto;
import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;
import br.sp.oz.portal.logistica.application.mappers.produto.ProdutoMapper;
import br.sp.oz.portal.logistica.application.ports.in.ProdutosPort;
import br.sp.oz.portal.logistica.application.ports.out.EnviarEmailUseCase;
import br.sp.oz.portal.logistica.application.ports.out.ProdutosRepositoryPort;
import br.sp.oz.portal.logistica.domain.exceptions.ProdutosNotFoundException;
import br.sp.oz.portal.logistica.domain.model.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdutosService implements ProdutosPort {

	private final ProdutoMapper produtoMapper;
	private final EnviarEmailUseCase emailGateway;
	private final ProdutosRepositoryPort produtosRepository;
	private final RabbitTemplate rabbitTemplate;

	private FileSystemResource converterDtosParaCsv(Page<?> produtosDto) {
		return PythonExecutor.executarConversaoCsv(produtosDto.toSet());
	}
	
	@Override
	public Page<ExtratoProdutoDto> recuperarProdutos(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable){
		Page<ExtratoProdutoDto> listaProdutosDto = recuperarListaProdutosPorJanelaData(dataInicio, dataFim, pageable).map(produtoMapper::produtosToExtratoProdutoDto);
		var email = emailGateway.solicitarEnvioExtratoProdutos(converterDtosParaCsv(listaProdutosDto));

		return listaProdutosDto;

	}
	
	@Override
	public Set<ProdutoDto> recuperarProdutos(LocalDate dataDiaUnico){
        return produtoMapper.produtosToProdutosDto(recuperarListaProdutosPorDia(dataDiaUnico));
	}
	
	@Override
	public Set<Produto> recuperarProdutos(LocalDateTime data){
		return recuperarExtratoProdutosPorData(data);
	}
	
	@Override
	public List<Produto> criarNovosProdutos(InserirProdutosRequest produtos) {
        Set<Produto> produtoEntity = new HashSet<>();
        for (ProdutoDto produto : produtos.produtos()) {
            produtoEntity.add(produtoMapper.produtoDtoToProduto(produto));
        }

        return salvarProdutos(produtoEntity);
    }

    protected List<Produto> salvarProdutos(Set<Produto> produtoEntity) {
		return produtosRepository.saveAll(produtoEntity);
	}
	
	@Override
	public Produto atualizarProduto(AtualizarProdutosRequest attProdutos) {
		Produto produto = recuperarProdutoPorId(attProdutos.idProduto());
		Produto produtoAtualizado = produtoMapper.produtoDtoToProduto(attProdutos.produto());
		produtoAtualizado.setId(produto.getId());

		return produtosRepository.saveAndFlush(produtoAtualizado);
	}
	
	
	private Produto recuperarProdutoPorId(Long idProduto) {
		return produtosRepository.findById(idProduto)
				.orElseThrow(ProdutosNotFoundException::new);
	}


	private Set<Produto> recuperarExtratoProdutosPorData(LocalDateTime dataPesquisaProdutos) {
		return produtosRepository.recuperarListaProdutosPorDataUnica(dataPesquisaProdutos);
	}


	private Page<Produto> recuperarListaProdutosPorJanelaData(LocalDateTime dataPesquisaProdutosInicio, LocalDateTime dataPesquisaProdutosFim, Pageable pageable){
		return produtosRepository.recuperarListaProdutosPorJanelaData(dataPesquisaProdutosInicio, dataPesquisaProdutosFim, pageable);
	}


	private Set<Produto> recuperarListaProdutosPorDia(LocalDate dataPesquisaProdutos){
		return produtosRepository.recuperarListaProdutosPorDiaUnico(dataPesquisaProdutos.atStartOfDay(), dataPesquisaProdutos.plusDays(1).atStartOfDay());
	}
}
