package com.aja.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackagesRequestDto {

    private String packageName;
    private Integer durationDays;
    private Double adultPrice;
    private Double childPrice;
    private Double foodPrice;
    private Double pickupPrice;
    private Double gstPercentage;

    
    private String imageUrl;

   
    private Long stateId;
}
