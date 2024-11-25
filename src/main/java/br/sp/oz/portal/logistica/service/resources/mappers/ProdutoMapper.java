
package br.sp.oz.portal.logistica.service.resources.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import br.sp.oz.portal.logistica.service.resources.dtos.ProdutoDto;
import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ProdutoMapper {

	
	Produtos produtoDtoToProduto(ProdutoDto produtoRequest);
	
}
