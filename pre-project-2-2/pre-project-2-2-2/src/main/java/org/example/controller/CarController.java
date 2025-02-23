package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Car;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public String getCars(@RequestParam(required = false) Integer count,
                          @RequestParam(required = false) String sortBy,
                          Model model) {
            try {
                List<Car> cars = carService.getCountCars(count, sortBy);
                model.addAttribute("cars", cars);
                return "cars";
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
    }
}
