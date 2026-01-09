package com.aja.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Enquiries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enquiryId;

	private String name;

	private String email;

	private Long mobileNo;

	private String message;

	private LocalDateTime createdAt = LocalDateTime.now();

	private boolean isFlag = true;// soft delete flag

}
