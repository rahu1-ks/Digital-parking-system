package com.nucompany.parkingsystem.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nucompany.parkingsystem.model.Floor;
import com.nucompany.parkingsystem.model.ParkingSpot;
import com.nucompany.parkingsystem.repository.FloorRepository;
import com.nucompany.parkingsystem.repository.ParkingSpotRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	private final FloorRepository floorRepo;
	private final ParkingSpotRepository spotRepo;

	public DataInitializer(FloorRepository floorRepo, ParkingSpotRepository spotRepo) {
		this.floorRepo = floorRepo;
		this.spotRepo = spotRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		if (floorRepo.count() > 0)
			return; // skip if data exists
		// Create 2 floors
		Floor f1 = new Floor(1);
		Floor f2 = new Floor(2);
		floorRepo.save(f1);
		floorRepo.save(f2);
		// Create spots
		// Floor 1: 5 CAR spots, 3 BIKE spots, 2 TRUCK spots
		for (int i = 0; i < 5; i++)
			spotRepo.save(new ParkingSpot("CAR", f1));
		for (int i = 0; i < 3; i++)
			spotRepo.save(new ParkingSpot("BIKE", f1));
		for (int i = 0; i < 2; i++)
			spotRepo.save(new ParkingSpot("TRUCK", f1));
		// Floor 2: 3 CAR, 2 BIKE, 1 TRUCK
		for (int i = 0; i < 3; i++)
			spotRepo.save(new ParkingSpot("CAR", f2));
		for (int i = 0; i < 2; i++)
			spotRepo.save(new ParkingSpot("BIKE", f2));
		for (int i = 0; i < 1; i++)
			spotRepo.save(new ParkingSpot("TRUCK", f2));
	}
}
