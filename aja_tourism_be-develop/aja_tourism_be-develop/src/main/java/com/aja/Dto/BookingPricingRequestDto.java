package com.aja.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingPricingRequestDto {

	private Double adultTotal;

	private Double childTotal;

	private Double foodTotal;

	private Double pickupTotal;

	private Double gstAmount;

	private Double finalAmount;
}
