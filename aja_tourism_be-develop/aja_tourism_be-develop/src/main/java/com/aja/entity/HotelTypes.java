package com.aja.entity;

import java.util.ArrayList;
import java.util.List;

import com.aja.constant.Meals;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class HotelTypes {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long hotelTypeId;

	private String htypeName;


	private Double pricePerday;
    
	@Enumerated(EnumType.STRING)
	private Meals meals;


	@OneToMany(mappedBy = "hoteltype")

	private List<Bookings> bookings = new ArrayList<>();

}
