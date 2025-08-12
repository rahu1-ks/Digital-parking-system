package com.nucompany.parkingsystem.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingResponseDTO {
	private Long ticketId;
	private Long spotId;
	private LocalDateTime entryTime;
    private String message;
}
