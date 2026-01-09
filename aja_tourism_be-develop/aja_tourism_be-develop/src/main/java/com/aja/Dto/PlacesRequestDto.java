package com.aja.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlacesRequestDto {

    @NotBlank(message = "Place name is mandatory")
    @Size(min = 3, max = 50, message = "Place name must be 3–50 characters")
    private String placeName;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 10, max = 255)
    private String description;

    @NotNull(message = "State id is required")
    private Long stateId;
}
