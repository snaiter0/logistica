package br.sp.oz.portal.logistica.controller.rest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.oz.portal.logistica.service.LogisticaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/")
public class LogisticaController {

	private final LogisticaService logisticaService;
	
	
	@GetMapping(value = "produto")
	public Object criarNovoProduto() {
		return logisticaService.criarNovoProduto(null);
	}
	
	
	@GetMapping(value = "produto:atualizar")
	public Object atalizarProduto() {
		return logisticaService.atualizarProduto();
	}
}
