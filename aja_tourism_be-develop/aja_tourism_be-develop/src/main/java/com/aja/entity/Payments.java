package com.aja.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	private String transactionId;

	private String paymentMethod;

	private String paymentStatus;

	private Double paidAmount;

	private LocalDateTime paidAt;

//	Relationships

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user; // OBJECT

	@OneToOne
	@JoinColumn(name = "booking_id")
	private Bookings booking;

	private boolean isFlag = true;// soft delete flag
}
