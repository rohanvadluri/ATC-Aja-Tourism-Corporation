package com.aja.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	private LocalDate travelDate;

	private Integer noOfAdults;

	private Integer noOfChildren;

	private String bookingStatus;


	private LocalDateTime createdAt;

	// Many bookings -> one user

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "package_id")
	private Packages packages;

	@ManyToOne
	@JoinColumn(name = "hoteltype_id")
	private HotelTypes hoteltype;

	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private Payments payment;

	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private BookingPricing bookingpricing;
	
    
    private boolean isFlag=true;
   
 

}
