package com.nucompany.parkingsystem.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnparkingResponseDTO {
	private Long spotId;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private double totalFee;
	private String vehicleNumber;
	private String vehicleType;
    private String message;
}
