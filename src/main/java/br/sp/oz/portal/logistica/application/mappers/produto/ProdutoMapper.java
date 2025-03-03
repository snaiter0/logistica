
package br.sp.oz.portal.logistica.application.mappers.produto;
import br.sp.oz.portal.logistica.application.dtos.produto.ExtratoProdutoDto;
import br.sp.oz.portal.logistica.application.dtos.produto.ProdutoDto;
import br.sp.oz.portal.logistica.domain.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import java.util.Set;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ProdutoMapper {

	Produto produtoDtoToProduto(ProdutoDto produtoRequest);


	Set<ProdutoDto> produtosToProdutosDto(Set<Produto> produto);
	
	Set<ExtratoProdutoDto> produtosToExtratoProdutosDto(Set<Produto> produto);

	ExtratoProdutoDto produtosToExtratoProdutoDto(Produto produto);

	@Mapping(target="destinatario", ignore = true)
	@Mapping(target="remetente", ignore = true)
    ProdutoDto produtoToProdutoDto(Produto produto);
}
