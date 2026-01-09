package com.aja.Dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaymentsResponseDto {

	private String transactionId;

	private String paymentMethod;

	private String paymentStatus;

	private Double paidAmount;

	private Long userId;
	private Long bookingId;

	private LocalDateTime paidAt;

}
