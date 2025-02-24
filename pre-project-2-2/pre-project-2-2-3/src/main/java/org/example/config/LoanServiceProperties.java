package org.example.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
@Data
@ConfigurationProperties(prefix = "loan")
public class LoanServiceProperties {

    private Integer minimalIncome;

    private Integer minimalCarPrice;

    private Integer monthsToCompute;

    private Double carPricePartToCompute;
}
