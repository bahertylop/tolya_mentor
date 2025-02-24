package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.config.CarServiceProperties;
import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.service.CarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarServiceProperties properties;

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public List<Car> getCountCars(Integer count, String sortBy) {
        if (count == null || count > properties.getMaxCountCars()) {
            count = properties.getMaxCountCars();
        }
        if (count != null && count <= 0) {
            return Collections.emptyList();
        }

        if (sortBy != null && !properties.getSortOnFields().contains(sortBy)) {
            throw new IllegalArgumentException("не подходит поле для сортировки");
        }

        PageRequest page = (sortBy == null) ?
                PageRequest.of(0, count) :
                PageRequest.of(0, count, Sort.by(sortBy));

        return carRepository.findLimitedCars(page);
    }
}
