package br.sp.oz.portal.logistica.service.repositories;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.sp.oz.portal.logistica.service.resources.entitys.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	@Query(value = "SELECT produto FROM Produtos produto "
			+ "where produto.dataHoraEntrada BETWEEN :dataDia and :dataTempoFimDia")
	Set<Produtos> recuperarListaProdutosPorDiaUnico(@Param("dataDia") LocalDateTime dataDia, @Param("dataTempoFimDia") LocalDateTime dataTempoFimDia);
	
	@Query(value = "SELECT produto FROM Produtos produto "
			+ "where produto.dataHoraEntrada BETWEEN :dataInicio AND :dataFim")
	Set<Produtos> recuperarListaProdutosPorJanelaData(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim")LocalDateTime dataFim);

	@Query(value = "SELECT produto FROM Produtos produto "
			+ "where produto.dataHoraEntrada BETWEEN :dataExtrato AND CURRENT_TIMESTAMP")
	Set<Produtos> recuperarListaProdutosPorDataUnica(@Param("dataExtrato") LocalDateTime dataExtrato);

}
