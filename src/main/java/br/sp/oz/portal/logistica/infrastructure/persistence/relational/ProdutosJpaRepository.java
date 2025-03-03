package br.sp.oz.portal.logistica.infrastructure.persistence.relational;

import java.time.LocalDateTime;
import java.util.Set;

import br.sp.oz.portal.logistica.domain.model.Produto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Primary
public interface ProdutosJpaRepository extends JpaRepository<Produto, Long>{

	@Query(value = "SELECT produto FROM Produto produto "
			+ "where produto.dataHoraEntrada BETWEEN :dataDia and :dataTempoFimDia")
	Set<Produto> recuperarListaProdutosPorDiaUnico(
			@Param("dataDia") LocalDateTime dataDia,
			@Param("dataTempoFimDia") LocalDateTime dataTempoFimDia);
	
	@Query(value = "SELECT produto FROM Produto produto "
			+ "where produto.dataHoraEntrada BETWEEN :dataInicio AND :dataFim")
	Page<Produto> recuperarListaProdutosPorJanelaData(
			@Param("dataInicio") LocalDateTime dataInicio,
			@Param("dataFim")LocalDateTime dataFim,
			Pageable pageable);

	@Query(value = "SELECT produto FROM Produto produto "
			+ "where produto.dataHoraEntrada BETWEEN :dataExtrato AND CURRENT_TIMESTAMP")
	Set<Produto> recuperarListaProdutosPorDataUnica(
			@Param("dataExtrato") LocalDateTime dataExtrato);
	
}
