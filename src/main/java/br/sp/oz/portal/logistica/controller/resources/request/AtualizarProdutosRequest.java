package br.sp.oz.portal.logistica.controller.resources.request;

import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.oz.portal.logistica.service.resources.dtos.ProdutoDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@RequestMapping
@Data
public class AtualizarProdutosRequest {

	private ProdutoDto produto;
	
	@NotNull
	private Long idProduto;
	
}
 