package com.nucompany.parkingsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nucompany.parkingsystem.dto.ParkingRequestDTO;
import com.nucompany.parkingsystem.dto.ParkingResponseDTO;
import com.nucompany.parkingsystem.dto.UnparkingResponseDTO;
import com.nucompany.parkingsystem.model.Ticket;
import com.nucompany.parkingsystem.service.ParkingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parking")
public class ParkingController {
	private final ParkingService parkingService;
	
	@PostMapping("/park")
	public ResponseEntity<ParkingResponseDTO> park(@RequestBody ParkingRequestDTO request) {
        Ticket ticket = parkingService.parkVehicle(request.getVehicleNumber(), request.getVehicleType());

        ParkingResponseDTO response = new ParkingResponseDTO();
        response.setTicketId(ticket.getTicketId());
        response.setSpotId(ticket.getParkingSpot().getId());
        response.setEntryTime(ticket.getEntryTime());
        response.setMessage("Vehicle parked successfully!");

        return ResponseEntity.ok(response);
    }
	
	@GetMapping("/unpark/{ticketId}")
    public ResponseEntity<UnparkingResponseDTO> unpark(@PathVariable Long ticketId) {
        Ticket ticket = parkingService.unparkVehicle(ticketId);

        UnparkingResponseDTO response = new UnparkingResponseDTO();
        response.setVehicleNumber(ticket.getVehicle().getVehicleNumber());
        response.setVehicleType(ticket.getVehicle().getVehicleType());
        response.setEntryTime(ticket.getEntryTime());
        response.setExitTime(ticket.getExitTime());
        response.setTotalFee(ticket.getTotalFee());
        response.setSpotId(ticket.getParkingSpot().getId());
        response.setMessage("Vehicle unparked successfully!");

        return ResponseEntity.ok(response);
    }
}
