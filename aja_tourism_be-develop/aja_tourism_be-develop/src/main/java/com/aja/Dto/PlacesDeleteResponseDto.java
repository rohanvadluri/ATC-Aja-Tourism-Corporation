package com.aja.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlacesDeleteResponseDto {
	
	@Column(name = "deleted", nullable = false)
	private boolean deleted = false;
	private String message = null;
}
