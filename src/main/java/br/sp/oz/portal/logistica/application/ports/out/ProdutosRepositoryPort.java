package br.sp.oz.portal.logistica.application.ports.out;

import br.sp.oz.portal.logistica.domain.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProdutosRepositoryPort {
    Set<Produto> recuperarListaProdutosPorDiaUnico(LocalDateTime dataDia, LocalDateTime dataTempoFimDia);

    Page<Produto> recuperarListaProdutosPorJanelaData(
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            Pageable pageable);

    Set<Produto> recuperarListaProdutosPorDataUnica(LocalDateTime dataExtrato);

    List<Produto> saveAll(Set<Produto> produtoEntity);

    Produto saveAndFlush(Produto produtoAtualizado);

    Optional<Produto> findById(Long idProduto);
}
