package br.sp.oz.portal.logistica.domain.model;

import br.sp.oz.portal.logistica.domain.model.base.ModelBase;
import jakarta.persistence.Column;
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

	@Column(name = "descricao_categoria", nullable = false)
	private String descricaoCategoria;

}
