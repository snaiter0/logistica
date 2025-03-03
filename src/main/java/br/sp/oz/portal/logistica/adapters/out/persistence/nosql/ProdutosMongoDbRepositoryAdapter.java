package br.sp.oz.portal.logistica.adapters.out.persistence.nosql;

import br.sp.oz.portal.logistica.application.ports.out.ProdutosRepositoryPort;
import br.sp.oz.portal.logistica.infrastructure.persistence.nosql.ProdutosMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProdutosMongoDbRepositoryAdapter {

    private final ProdutosMongoRepository produtosMongoRepository;
}
