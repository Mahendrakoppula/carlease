package com.CarLease.CarLease.service.carService;

import com.CarLease.CarLease.DTO.CarDto.CarDTO;
import com.CarLease.CarLease.Entity.Car;
import com.CarLease.CarLease.ResponseMessage.CarResponse.CarResponse;

import java.util.List;

public interface Carinterface {
     Car addCar(Car car);
     List<Car> getallcars();

     CarResponse filterCars(String name, String color, String model);
}
