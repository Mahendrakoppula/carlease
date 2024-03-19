package com.CarLease.CarLease.service.driver;

import com.CarLease.CarLease.Entity.Driver;

import java.util.List;

public interface DriverInterface {

    Driver addDriver(Driver driver);
    List<Driver> getallDrivers();
}
