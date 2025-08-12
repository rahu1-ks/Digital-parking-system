package com.nucompany.parkingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucompany.parkingsystem.model.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

	List<ParkingSpot> findByVehicleTypeAllowedAndOccupiedFalseOrderByIdAsc(String vehicleType);

}
