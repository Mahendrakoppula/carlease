package com.CarLease.CarLease.DTO.leaseDto;

import com.CarLease.CarLease.DTO.CarDto.CarDTO;
import com.CarLease.CarLease.Entity.Lease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseDto {
    private String status;
//    private CarDTO carDto;
//    private String Message;
    private int car_id;
    private int driver_id;

}
