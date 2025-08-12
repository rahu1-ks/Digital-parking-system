package com.nucompany.parkingsystem.model;

import java.time.LocalDateTime;

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
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	
	@ManyToOne
	private Vehicle vehicle;
	
	@ManyToOne
	private ParkingSpot parkingSpot;
	
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private double totalFee;
}
