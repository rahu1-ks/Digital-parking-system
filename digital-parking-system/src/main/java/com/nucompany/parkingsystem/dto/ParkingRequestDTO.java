package com.nucompany.parkingsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequestDTO {
	private String vehicleNumber;
    private String vehicleType;
}
