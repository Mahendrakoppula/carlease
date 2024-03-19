package com.CarLease.CarLease.Repository.DriverRepository;

import com.CarLease.CarLease.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,Long> {
}
