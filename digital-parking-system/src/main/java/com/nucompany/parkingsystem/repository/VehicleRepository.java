package com.nucompany.parkingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nucompany.parkingsystem.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
