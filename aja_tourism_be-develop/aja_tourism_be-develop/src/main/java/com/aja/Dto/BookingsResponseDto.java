package com.aja.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingsResponseDto {

	private LocalDate travelDate;

	private Integer noOfAdults;

	private Integer noOfChildren;

	private String bookingStatus;

	private LocalDateTime createdAt;
	
	private Long userId;
	
	private Long packageId;
}
