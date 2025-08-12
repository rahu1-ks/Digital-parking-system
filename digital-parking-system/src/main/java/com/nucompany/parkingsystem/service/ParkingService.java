package com.nucompany.parkingsystem.service;

import com.nucompany.parkingsystem.model.Ticket;

public interface ParkingService {
	Ticket parkVehicle(String vehicleNumber, String vehicleType);
	Ticket unparkVehicle(Long ticketId);
}
