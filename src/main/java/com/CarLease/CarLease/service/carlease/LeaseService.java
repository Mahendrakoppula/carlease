package com.CarLease.CarLease.service.carlease;

import com.CarLease.CarLease.DTO.leaseDto.LeaseDto;
import com.CarLease.CarLease.Entity.Car;
import com.CarLease.CarLease.Entity.Lease;
import com.CarLease.CarLease.Repository.CarRepository.CarRepo;
import com.CarLease.CarLease.Repository.LeaseRepository.LeaseRepo;
import com.CarLease.CarLease.ResponseMessage.leaseResponse.LeaseResponse;
import com.CarLease.CarLease.exceptions.leaseException.CarLeasedException;
import org.springframework.stereotype.Service;

@Service
public class LeaseService implements LeaseInterface {

//    private static final Log LOG = LogFactory.getLog(LeaseService.class);
    private LeaseRepo leaseRepo;
    private CarRepo carRepo;
    public LeaseService(LeaseRepo leaseRepo,CarRepo carRepo) {
        this.leaseRepo = leaseRepo;
        this.carRepo = carRepo;
    }
//    public LeaseResponse createLease(Lease lease) {
//        System.out.println("car id from service "+lease.getCar_id());
//        if(leaseRepo.existsarId((long) lease.getCar_id())){
//            System.out.println("true");
//          return new LeaseResponse("car has been booked already with id");
//        }else {
//            var result= leaseRepo.save(lease);
//            System.out.println("fasled");
//            System.out.println(result);
////            return new LeaseDto(lease.getStatus(),"car has been booked",lease.getCar_id(),lease.getDriver_id());
//            return new LeaseResponse("Car has een leased",new LeaseDto(lease.getStatus(),lease.getCar_id(), lease.getDriver_id()));
////            return LeaseDto.build(String.valueOf(lease.getDriver_id()), "car has been booked", lease.getCar_id(), lease.getDriver_id());
//        }
//
//    }
public LeaseResponse createLease(Lease lease) {
    System.out.println("car id from service " + lease.getCar_id());
    if (leaseRepo.existsarId((long) lease.getCar_id())) {
        System.out.println("true");
        throw new CarLeasedException("Thi Car id has been leased" );
//        return new LeaseResponse("car has been booked already with id");
    } else {
        var result = leaseRepo.save(lease);
        System.out.println("failed");
        System.out.println(result);
        return new LeaseResponse("Car has been leased", new LeaseDto(lease.getStatus(), lease.getCar_id(), lease.getDriver_id()));
    }
}


//    @Override
//    public String droplease(long id) {
//        System.out.println(leaseRepo.existsarId(id));
//        var carid=leaseRepo.existsByCarId(id);
//        System.out.println(carid.getCar_id()+carid.getDriver_id());
//        if(!leaseRepo.existsarId(id)){
//            throw new CarLeasedException("there is no car leased with this id");
//        }
//        leaseRepo.deleteByCarId(id);
//        return "droped with carid "+carid.getCar_id()+" driver id "+carid.getDriver_id();
//    }

    @Override
    public String droplease(long id) {
        // Check if lease exists with the given car id
        if (leaseRepo.existsByCarId(id)!=null) {
            // If lease exists, delete it
            leaseRepo.deleteByCarId(id);
            return "Lease dropped successfully for car id: " + id;
        } else {
            // If lease doesn't exist, throw a CarLeasedException
            throw new CarLeasedException("Car id has not been leased");
        }
    }

}
