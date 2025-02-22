package org.example.service;

import org.example.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCountCars(Integer count);
}
