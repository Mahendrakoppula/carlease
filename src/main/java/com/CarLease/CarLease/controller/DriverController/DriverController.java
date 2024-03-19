package com.CarLease.CarLease.controller.DriverController;

import com.CarLease.CarLease.Entity.Driver;
import com.CarLease.CarLease.service.driver.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/addDriver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        var result=driverService.addDriver(driver);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/alldrivers")
    public ResponseEntity<List<Driver>> getalldrivers(){
        var result=driverService.getallDrivers();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
