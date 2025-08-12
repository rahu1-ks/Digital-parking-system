package com.nucompany.parkingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingSpot {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleTypeAllowed;
    private boolean occupied;

    @ManyToOne
    private Floor floor;
    
    public ParkingSpot(String vehicleTypeAllowed, Floor floor) {
    	this.vehicleTypeAllowed = vehicleTypeAllowed;
    	this.floor = floor;
    	this.occupied = false;
    }
}