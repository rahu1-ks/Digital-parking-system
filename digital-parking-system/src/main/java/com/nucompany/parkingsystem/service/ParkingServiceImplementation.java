package com.nucompany.parkingsystem.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nucompany.parkingsystem.model.ParkingSpot;
import com.nucompany.parkingsystem.model.Ticket;
import com.nucompany.parkingsystem.model.Vehicle;
import com.nucompany.parkingsystem.repository.ParkingSpotRepository;
import com.nucompany.parkingsystem.repository.TicketRepository;
import com.nucompany.parkingsystem.repository.VehicleRepository;

@Service
public class ParkingServiceImplementation implements ParkingService{
	private final ParkingSpotRepository spotRepo;
	private final VehicleRepository vehicleRepo;
	private final TicketRepository ticketRepo;
	
	private final Map<String, Double> rates = Map.of(
			"BIKE", 10.0,
			"CAR", 20.0,
			"TRUCK", 30.0
	);
	
	public ParkingServiceImplementation(ParkingSpotRepository spotRepo, VehicleRepository vehicleRepo,
			TicketRepository ticketRepo) {
		this.spotRepo = spotRepo;
		this.vehicleRepo = vehicleRepo;
		this.ticketRepo = ticketRepo;
	}
	
	@Override
	@Transactional
	public Ticket parkVehicle(String vehicleNumber, String vehicleType) {
		vehicleType = vehicleType.toUpperCase();
		// create or load vehicle
		Vehicle vehicle = vehicleRepo.findById(vehicleNumber).orElse(null);
		if (vehicle == null) {
			vehicle = new Vehicle(vehicleNumber, vehicleType);
		}
		vehicle.setVehicleType(vehicleType);
		vehicleRepo.save(vehicle);
		// find nearest available spot for vehicleType
		List<ParkingSpot> available = spotRepo.findByVehicleTypeAllowedAndOccupiedFalseOrderByIdAsc(vehicleType);
		if (available.isEmpty()) {
			throw new RuntimeException("No available spot for type: " +
			vehicleType);
		}
		ParkingSpot spot = available.get(0);
		spot.setOccupied(true);
		spotRepo.save(spot);
		Ticket ticket = new Ticket();
		ticket.setVehicle(vehicle);
		ticket.setParkingSpot(spot);
		ticket.setEntryTime(LocalDateTime.now());
		ticketRepo.save(ticket);
		return ticket;
	}
	
	@Override
	@Transactional
	public Ticket unparkVehicle(Long ticketId) {
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
		if (ticket.getExitTime() != null) {
			return ticket; // already unparked
		}
		ticket.setExitTime(LocalDateTime.now());
		// calculate hours (round up), minimum 1
		Duration dur = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
		long minutes = dur.toMinutes();
		long hours = minutes / 60;
		if (minutes % 60 != 0) 
			hours += 1;
		if (hours == 0) 
			hours = 1; // minimum billing
		String vt = ticket.getVehicle().getVehicleType().toUpperCase();
		Double rate = rates.getOrDefault(vt, 20.0);
		double fee = rate * hours;
		ticket.setTotalFee(fee);
		// free spot
		ParkingSpot spot = ticket.getParkingSpot();
		spot.setOccupied(false);
		spotRepo.save(spot);
		ticketRepo.save(ticket);
		return ticket;
	}
}
