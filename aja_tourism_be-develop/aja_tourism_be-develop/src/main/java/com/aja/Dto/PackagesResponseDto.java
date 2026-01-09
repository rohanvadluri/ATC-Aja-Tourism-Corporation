package com.aja.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackagesResponseDto {
	
	private Long packageId;

	private String packageName;

	private Integer durationDays;

	private Double adultPrice;

	private Double childPrice;

	private Double foodPrice;

	private Double pickupPrice;

	private Double gstPercentage;
	
	private String imageUrl;

}
