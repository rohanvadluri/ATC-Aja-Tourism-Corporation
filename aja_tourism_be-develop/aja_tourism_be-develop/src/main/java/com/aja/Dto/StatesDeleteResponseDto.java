package com.aja.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatesDeleteResponseDto {

	@Column(name = "deleted", nullable = false)
	private boolean deleted = false;
	private String message = null;
}
