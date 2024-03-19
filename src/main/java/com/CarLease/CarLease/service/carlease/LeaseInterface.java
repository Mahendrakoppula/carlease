package com.CarLease.CarLease.service.carlease;

import com.CarLease.CarLease.DTO.leaseDto.LeaseDto;
import com.CarLease.CarLease.Entity.Lease;
import com.CarLease.CarLease.ResponseMessage.leaseResponse.LeaseResponse;

public interface LeaseInterface {
    public LeaseResponse createLease(Lease lease);
    public String droplease(long id);
}
