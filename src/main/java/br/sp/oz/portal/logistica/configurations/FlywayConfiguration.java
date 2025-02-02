package br.sp.oz.portal.logistica.configurations;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfiguration{
	
    @Bean
    public MigrateResult FlywayConfig(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration") // onde os scripts de migração estão localizados
                .load().migrate();
    }
}