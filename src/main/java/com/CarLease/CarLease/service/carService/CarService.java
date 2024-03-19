package com.CarLease.CarLease.service.carService;

import com.CarLease.CarLease.DTO.CarDto.CarDTO;
import com.CarLease.CarLease.Entity.Car;
import com.CarLease.CarLease.Repository.CarRepository.CarRepo;
import com.CarLease.CarLease.ResponseMessage.CarResponse.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements Carinterface {

    @Autowired
    private CarRepo carRepo;
    @Override
    public Car addCar(Car car) {

        return carRepo.save(car);
    }

    @Override
    public List<Car> getallcars() {
        return carRepo.findAll();
    }

    public CarResponse filterCars(String name, String color, String model) {
        List<Car> result;

        if (name != null && color != null && model != null) {
            result = carRepo.findByNameAndColorAndModel(name, color, model);
        } else if (name != null && color != null) {
            result = carRepo.findByNameAndColor(name, color);
        } else if (name != null && model != null) {
            result = carRepo.findByNameAndModel(name, model);
        } else if (color != null && model != null) {
            result = carRepo.findByColorAndModel(color, model);
        } else if (name != null) {
            result = carRepo.findByName(name);
        } else if (color != null) {
            result = carRepo.findByColor(color);
        } else if (model != null) {
            result = carRepo.findByModel(model);
        } else {
            result = carRepo.findAll();
        }

        List<CarDTO> carDTOs = result.stream()
                .map(car -> new CarDTO(car.getName(), car.getModel(), car.getColor()))
                .collect(Collectors.toList());

        return CarResponse.of("cars retrieved successfully", carDTOs);
    }
}
