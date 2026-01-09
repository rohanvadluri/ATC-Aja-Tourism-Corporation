package com.aja.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDeleteResponseDto {
	@Column(name = "deleted", nullable = false)
	@JsonIgnore
	private boolean deleted = false;
	private String message = null;

}
