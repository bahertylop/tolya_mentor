package my.starter.config;

import my.starter.service.IncomeApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IncomeClientConfiguration {

    private final String apiUrl;

    public IncomeClientConfiguration(@Value("${api.url}") String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Bean
    public IncomeApiService getIncomeApiService() {
        return new IncomeApiService(apiUrl);
    }
}
