package com.aja.Dto;
 
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aja.constant.IdentityProofType;
import com.aja.entity.Nationality;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponseDto {
	private Long userId;
	private String fullName;
 
	@Column(nullable = false)
	private String password;
 
	private String confirmPassword;
 
	private String profileImage;
 
	private LocalDate dateOfBirth;
 
	private LocalDateTime createdAt = LocalDateTime.now();
 
	@Column(unique = true, nullable = false)
	private String email;
 
	@NotBlank(message = "Enter 10 digits mobile number")
	private String mobileNo;
 
	@NotNull(message = "Nationality is required")
	private Nationality nationality;
 
	private IdentityProofType identityProofType;
 
	private String identityProofNumber;
 
}
