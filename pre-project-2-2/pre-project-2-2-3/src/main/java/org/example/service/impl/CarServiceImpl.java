package org.example.service.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final Integer maxCountCars;

    private final List<String> sortOnFields;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          @Value("${app.car-service.max-car-count}") Integer maxCountCars,
                          @Value("${app.car-service.sort-on-fields}") List<String> sortOnFields
    ) {
        this.carRepository = carRepository;
        this.maxCountCars = maxCountCars;
        this.sortOnFields = sortOnFields;
    }


    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public List<Car> getCountCars(Integer count, String sortBy) {
        if (count == null || count > maxCountCars) {
            count = maxCountCars;
        }
        if (count <= 0) {
            return Collections.emptyList();
        }

        if (sortBy != null && !sortOnFields.contains(sortBy)) {
            throw new IllegalArgumentException("не подходит поле для сортировки");
        }

        PageRequest page = (sortBy == null) ?
                PageRequest.of(0, count) :
                PageRequest.of(0, count, Sort.by(sortBy));

        return carRepository.findLimitedCars(page);
    }
}
