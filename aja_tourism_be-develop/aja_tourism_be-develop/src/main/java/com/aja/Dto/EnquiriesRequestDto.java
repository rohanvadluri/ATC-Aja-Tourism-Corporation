package com.aja.Dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EnquiriesRequestDto {
	
	private String name;

	private String email;

	private Long mobileNo;

	private String message;

	private LocalDateTime createdAt = LocalDateTime.now();
}
