package com.aja.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentsRequestDto {

	private String transactionId;

	private String paymentMethod;

	private String paymentStatus;

	private Double paidAmount;

	private Long userId; // VALUE
	private Long bookingId;

	private LocalDateTime paidAt;

}
