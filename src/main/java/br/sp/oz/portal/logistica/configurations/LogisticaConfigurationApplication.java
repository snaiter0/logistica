package br.sp.oz.portal.logistica.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaAuditing
public class LogisticaConfigurationApplication extends RestTemplate{

	
}
