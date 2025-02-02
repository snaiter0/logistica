package br.sp.oz.portal.logistica.service.resources.entitys;

import br.sp.oz.portal.logistica.service.resources.entitys.base.ModelBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "categoria_produto", schema = "dbo")
public class CategoriaProduto extends ModelBase {
	
	private String descricaoCategoria;

}
