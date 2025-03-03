package br.sp.oz.portal.logistica.adapters.out.persistence.relational;

import br.sp.oz.portal.logistica.application.ports.out.ProdutosRepositoryPort;
import br.sp.oz.portal.logistica.domain.model.Produto;
import br.sp.oz.portal.logistica.infrastructure.persistence.relational.ProdutosJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ProdutosJpaRepositoryAdapter implements ProdutosRepositoryPort{

    private final ProdutosJpaRepository produtosJpaRepository;

    @Override
    public Set<Produto> recuperarListaProdutosPorDiaUnico(LocalDateTime dataDia, LocalDateTime dataTempoFimDia){
        return produtosJpaRepository.recuperarListaProdutosPorDiaUnico(dataDia, dataTempoFimDia);
    }

    @Override
    public Page<Produto> recuperarListaProdutosPorJanelaData(
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            Pageable pageable){
        return produtosJpaRepository.recuperarListaProdutosPorJanelaData(dataInicio, dataFim, pageable);
    }

    @Override
    public Set<Produto> recuperarListaProdutosPorDataUnica(LocalDateTime dataExtrato){
        return produtosJpaRepository.recuperarListaProdutosPorDataUnica(dataExtrato);
    }

    @Override
    public List<Produto> saveAll(Set<Produto> produtoEntity) {
        return produtosJpaRepository.saveAll(produtoEntity);
    }

    @Override
    public Produto saveAndFlush(Produto produtoAtualizado) {
        return produtosJpaRepository.saveAndFlush(produtoAtualizado);
    }

    @Override
    public Optional<Produto> findById(Long idProduto) {
        return produtosJpaRepository.findById(idProduto);
    }
}
