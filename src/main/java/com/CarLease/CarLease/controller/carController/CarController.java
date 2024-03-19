package com.CarLease.CarLease.controller.carController;

import com.CarLease.CarLease.DTO.CarDto.CarDTO;
import com.CarLease.CarLease.Entity.Car;
import com.CarLease.CarLease.ResponseMessage.CarResponse.CarResponse;
import com.CarLease.CarLease.service.carService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Adjust the number of threads as needed

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/addcar")
    public ResponseEntity<Car> SaveCAr(@RequestBody Car car){
        var result= carService.addCar(car);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PostMapping("/addcars")
    public ResponseEntity<String> SaveCar(@RequestBody List<Car> car){
         executorService.execute(()->carService.addCar((Car) car));
//        var result= carService.addCar(car);
        return new ResponseEntity<>("Cars created", HttpStatus.CREATED);
    }

    @GetMapping("/cars/filter")
    public ResponseEntity<CarListResponse> getAllCars(){
        List<Car> cars=carService.getallcars();

        String message = "All cars are retrieved successfully.";

        List<CarDTO> carDTOS=cars.stream().map(car -> new CarDTO(car.getName(), car.getModel(), car.getColor())).collect(Collectors.toList());
        CarListResponse response = new CarListResponse(message, carDTOS);
//        return new ResponseEntity<>(carDTOS,HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/cars")
    public ResponseEntity<CarResponse> filterCars(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String model) {

        CarResponse filteredCars = carService.filterCars(name, color, model);

        if (filteredCars.getData().isEmpty()) {
            return ResponseEntity.noContent().build(); // No content found
        } else {
            return ResponseEntity.ok(filteredCars); // Found cars
        }
    }

    public static class CarListResponse {
        private String message;
        private List<CarDTO> cars;

        public CarListResponse(String message, List<CarDTO> cars) {
            this.message = message;
            this.cars = cars;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<CarDTO> getCars() {
            return cars;
        }

        public void setCars(List<CarDTO> cars) {
            this.cars = cars;
        }
    }
}
