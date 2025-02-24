package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@ConfigurationProperties(prefix = "app.car-service")
public class CarServiceProperties {

    private Integer maxCountCars;

    private List<String> sortOnFields;
}
