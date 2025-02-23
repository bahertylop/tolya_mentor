package org.example.service.impl;

import org.example.dto.UserIncome;
import org.example.service.IncomeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class IncomeApiService implements IncomeService {

    private final String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public IncomeApiService(@Value("${app.income-api-service.api-url}") String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public List<UserIncome> getIncomeData() {
        try {
            ResponseEntity<List<UserIncome>> response =
                    restTemplate.exchange(apiUrl,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<UserIncome>>() {
                            });

            return response.getBody();
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public UserIncome getUserIncome(Long userId) {
        List<UserIncome> incomes = getIncomeData();
        Optional<UserIncome> userIncomeOp = incomes.stream().filter((x) -> x.getId().equals(userId)).findFirst();
        return userIncomeOp.orElse(new UserIncome(userId, 0));
    }


}
