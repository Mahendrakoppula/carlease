package com.CarLease.CarLease.controller.leaseController;

import com.CarLease.CarLease.DTO.leaseDto.LeaseDto;
import com.CarLease.CarLease.Entity.Lease;
import com.CarLease.CarLease.service.carlease.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lease")
public class LeaseController {
    @Autowired
    private LeaseService leaseService;

    @PostMapping("/book")
    public ResponseEntity<?> addLease(@RequestBody Lease lease) {
        // Print incoming request payload to console
        System.out.println("Incoming request payload: " + lease.toString());
        var result = leaseService.createLease(lease);
        System.out.println("***********");
        System.out.println("result from controller: " + result);

        if (result.getData() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
        }
    }

    @PostMapping("/drop/{id}")
    public ResponseEntity droplease(@PathVariable long id){
        String result=leaseService.droplease(id);
        if (!result.equals("droped")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
