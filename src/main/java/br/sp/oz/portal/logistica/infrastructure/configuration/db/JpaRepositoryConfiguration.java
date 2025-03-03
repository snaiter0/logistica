package br.sp.oz.portal.logistica.infrastructure.configuration.db;

import br.sp.oz.portal.logistica.infrastructure.persistence.relational.ProdutosJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {
        ProdutosJpaRepository.class
})
public class JpaRepositoryConfiguration {
}
