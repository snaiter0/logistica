package br.sp.oz.portal.logistica.adapters.in.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import br.sp.oz.portal.logistica.domain.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.sp.oz.portal.logistica.adapters.in.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.adapters.in.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.adapters.in.controller.resources.routes.Rotas;
import br.sp.oz.portal.logistica.application.ports.in.ProdutosPort;
import br.sp.oz.portal.logistica.application.dtos.produto.ExtratoProdutoDto;
import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = Rotas.API_LOGISTICA)
@Tag(name = "Produto", description = "Operações relacionadas aos produtos")
@RestController
@Validated
public class ProdutosController{

    private final ProdutosPort logisticaService;

      @Operation(
	        summary = "Criar Novo Produto",
	        description = "Adiciona um novo produto ao sistema com os dados fornecidos no corpo da requisição.")
	        @PostMapping(value = Rotas.Produtos.BASE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> InserirNovosProdutos(
    	 @Parameter(description = "Dados do produto a ser inserido", required = true)
    		@RequestBody InserirProdutosRequest produtoRequest) {
        logisticaService.criarNovosProdutos(produtoRequest);
        return new ResponseEntity<>("📩 Produto enviado para a fila de processamento", HttpStatus.ACCEPTED);
    }
	
    @Operation(
        summary = "Atualizar Produto",
        description = "Atualiza os dados de um produto existente com as informações fornecidas.")
    @PatchMapping(value = Rotas.Produtos.ADICIONAR, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> atualizarProduto(
        @Parameter(description = "Dados do produto a ser atualizado", required = true) 
        @RequestBody AtualizarProdutosRequest atualizarProduto) {
        return new ResponseEntity<>(logisticaService.atualizarProduto(atualizarProduto), HttpStatus.OK);
    }
    
    @Operation(
            summary = "Recupera lista de produtos por data",
            description = "Recupera lista de produtos no banco de dados do sistema a partir da data no corpo da requisição.")
    @GetMapping(value = Rotas.Produtos.BASE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Produto>> recuperarExtratoProdutosPorData(
    @Parameter(description = "Data dos produto a serem recuperados", required = true) 
    @RequestParam("dataProduto") LocalDateTime dataProduto){
    	return new ResponseEntity<>(logisticaService.recuperarProdutos(dataProduto), HttpStatus.OK);
    }
    
    
    @Operation(
            summary = "Recupera lista de produtos por data dia",
            description = "Recupera lista de produtos no banco de dados do sistema a partir da data do dia no corpo da requisição.")
    @GetMapping(value = Rotas.Produtos.PRODUTOS_POR_DIA, produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Set<ProdutoDto>> recuperarProdutosPorDataDia(
    	    @Parameter(description = "Data dia dos produto a serem recuperados", required = true) 
    	    @RequestParam("dataDiaProduto") LocalDate dataDiaProduto){
    	    	return new ResponseEntity<>(logisticaService.recuperarProdutos(dataDiaProduto), HttpStatus.OK);
    	    }
    
    @Operation(
            summary = "Recupera lista de produtos dentro de uma janela de datas",
            description = "Recupera lista de produtos no banco de dados do sistema a partir de uma janela de datas no corpo da requisição.")
    @GetMapping(value = Rotas.Produtos.PRODUTOS_POR_DATA_JANELA, produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Page<ExtratoProdutoDto>> recuperarProdutosPorJanelaData(
    	    @Parameter(description = "Janela de datas de dias dos produto a serem recuperados", required = true) 
    	    @RequestParam("dataDiaProduto") LocalDateTime dataInicioProduto,
    	    @RequestParam("dataFimProduto") LocalDateTime dataFimProduto,
    	    Pageable pageable){
    			return new ResponseEntity<>(logisticaService.recuperarProdutos(dataInicioProduto, dataFimProduto, pageable), HttpStatus.OK);
    	    }
}