package com.CarLease.CarLease.service.driver;

import com.CarLease.CarLease.Entity.Driver;
import com.CarLease.CarLease.Repository.DriverRepository.DriverRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements DriverInterface{

    private DriverRepo driverRepo;

    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public Driver addDriver(Driver driver) {
        Driver result= driverRepo.save(driver);
        return result;
    }

    @Override
    public List<Driver> getallDrivers() {
        return driverRepo.findAll();
    }
}
