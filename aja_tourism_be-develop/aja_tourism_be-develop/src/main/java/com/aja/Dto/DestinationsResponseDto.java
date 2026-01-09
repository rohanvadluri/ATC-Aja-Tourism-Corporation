package com.aja.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationsResponseDto {

    private Long destinationId;
    private String imageUrl;
    private String description;
    private Long placeId;
    private String placeName;
}
