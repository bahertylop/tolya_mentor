package org.example.service;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final Integer maxCountCars;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, @Value("${maxCar}") Integer maxCountCars) {
        this.carRepository = carRepository;
        this.maxCountCars = maxCountCars;
    }


    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public List<Car> getCountCars(Integer count) {
        if (count ==  null) {
            return getAllCars();
        }
        if (count <= 0) {
            return new ArrayList<>();
        }
        count = Math.min(count, maxCountCars);
        return carRepository.findLimitedCars(PageRequest.of(0, count));
    }
}
