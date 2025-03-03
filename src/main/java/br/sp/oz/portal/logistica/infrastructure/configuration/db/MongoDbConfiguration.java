package br.sp.oz.portal.logistica.infrastructure.configuration.db;

import br.sp.oz.portal.logistica.infrastructure.persistence.nosql.ProdutosMongoRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackageClasses = {ProdutosMongoRepository.class}
)
public class MongoDbConfiguration {
}
