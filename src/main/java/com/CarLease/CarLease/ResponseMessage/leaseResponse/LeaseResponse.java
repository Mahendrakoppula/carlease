package com.CarLease.CarLease.ResponseMessage.leaseResponse;

import com.CarLease.CarLease.DTO.leaseDto.LeaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseResponse {
    private String message;
    private LeaseDto data;

    public LeaseResponse(String message) {
        this.message = message;
    }
}
