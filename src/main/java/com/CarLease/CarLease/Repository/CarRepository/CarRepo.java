package com.CarLease.CarLease.Repository.CarRepository;

import com.CarLease.CarLease.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {

    List<Car> findByName(String name);

    List<Car> findByColor(String color);

    List<Car> findByModel(String model);

    List<Car> findByNameAndColor(String name, String color);

    List<Car> findByNameAndModel(String name, String model);

    List<Car> findByColorAndModel(String color, String model);

    List<Car> findByNameAndColorAndModel(String name, String color, String model);
}
