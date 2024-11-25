package br.sp.oz.portal.logistica.controller.rest.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.oz.portal.logistica.controller.resources.request.AtualizarProdutosRequest;
import br.sp.oz.portal.logistica.controller.resources.request.InserirProdutosRequest;
import br.sp.oz.portal.logistica.service.LogisticaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/")
@Tag(name = "Produto", description = "Operações relacionadas aos produtos. ")
public class ProdutosController {

	private final LogisticaService logisticaService;
	
	
	@PostMapping(value = "produto", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object criarNovoProduto(InserirProdutosRequest produtoRequest) {
		return logisticaService.criarNovosProdutos(null);
	}
	
	
	@GetMapping(value = "produto:atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object atalizarProduto(AtualizarProdutosRequest atualizarProduto) {
		return logisticaService.atualizarProduto(atualizarProduto);
	}
}
