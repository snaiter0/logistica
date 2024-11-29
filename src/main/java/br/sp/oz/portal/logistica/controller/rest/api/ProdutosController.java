package br.sp.oz.portal.logistica.controller.rest.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.oz.portal.logistica.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.service.LogisticaService;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
@Tag(name = "Produto", description = "Operações relacionadas aos produtos")
@Validated
public class ProdutosController {

    private final LogisticaService logisticaService;

    @Operation(
        summary = "Criar Novo Produto",
        description = "Adiciona um novo produto ao sistema com os dados fornecidos no corpo da requisição.")
    @PostMapping(value = "produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produtos>> criarNovoProduto(
        @Parameter(description = "Dados do produto a ser inserido", required = true) 
        @RequestBody InserirProdutosRequest produtoRequest) {
        return new ResponseEntity<>(logisticaService.criarNovosProdutos(produtoRequest), HttpStatus.CREATED);
    }
	
    @Operation(
        summary = "Atualizar Produto",
        description = "Atualiza os dados de um produto existente com as informações fornecidas.")
    @PatchMapping(value = "produto:atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produtos> atualizarProduto(
        @Parameter(description = "Dados do produto a ser atualizado", required = true) 
        @RequestBody AtualizarProdutosRequest atualizarProduto) {
        return new ResponseEntity<>(logisticaService.atualizarProduto(atualizarProduto), HttpStatus.OK);
    }
}

