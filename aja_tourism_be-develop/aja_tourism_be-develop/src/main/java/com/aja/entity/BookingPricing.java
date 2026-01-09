package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class BookingPricing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pricingId;

	private Double adultTotal;

	private Double childTotal;

	private Double foodTotal;

	private Double pickupTotal;

	private Double gstAmount;

	private Double finalAmount;

	@OneToOne
	@JoinColumn(name = "booking_id")
	private Bookings booking;

}
