package br.sp.oz.portal.logistica.service.resources.entitys;

import br.sp.oz.portal.logistica.service.resources.entitys.base.AbstractModelBase;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaProduto extends AbstractModelBase {
	
	private String descricaoCategoria;

}
