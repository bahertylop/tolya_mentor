package my.starter.config;

import my.starter.service.IncomeApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApiProperties.class)
public class IncomeClientConfiguration {

    private final ApiProperties apiProperties;

    public IncomeClientConfiguration(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @Bean
    public IncomeApiService getIncomeApiService() {
        return new IncomeApiService(apiProperties.getUrl());
    }
}
