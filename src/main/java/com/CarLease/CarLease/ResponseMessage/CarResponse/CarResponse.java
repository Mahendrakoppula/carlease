package com.CarLease.CarLease.ResponseMessage.CarResponse;

import com.CarLease.CarLease.DTO.CarDto.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CarResponse {
    private String message;
    private List<CarDTO> data; // Change carDTO to data
}
