package br.sp.oz.portal.logistica.infrastructure.persistence.nosql;

import br.sp.oz.portal.logistica.domain.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutosMongoRepository extends MongoRepository<Produto, Long> {

}
