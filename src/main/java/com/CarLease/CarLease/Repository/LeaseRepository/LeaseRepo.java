package com.CarLease.CarLease.Repository.LeaseRepository;

import com.CarLease.CarLease.Entity.Lease;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LeaseRepo extends JpaRepository<Lease,Long> {
    @Query("SELECT c FROM Lease c WHERE c.car_id = :carId")
    Lease existsByCarId(Long carId);
    default boolean existsarId(Long carId) {
        Lease lease = existsByCarId(carId);
        return lease != null;
    }
    @Transactional
    @Modifying
    @Query("DELETE FROM Lease c WHERE c.car_id = :carId")
    void deleteByCarId(Long carId);
}
