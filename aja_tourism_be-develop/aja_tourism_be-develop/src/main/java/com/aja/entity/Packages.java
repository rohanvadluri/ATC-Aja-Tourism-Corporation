package com.aja.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageId;

	private String packageName;

	private Integer durationDays;

	private Double adultPrice;

	private Double childPrice;

	private Double foodPrice;

	private boolean isFlag = true;

	private Double pickupPrice;

	private Double gstPercentage;
	
	private String imageUrl;

//	Relationships

	@ManyToOne
	@JoinColumn(name = "state_id")
	private States state;

	@OneToMany(mappedBy = "packages")
	private List<Bookings> booking = new ArrayList<>();

//	@OneToMany(mappedBy = "packages")
//	private List<Testimonials> testimonial = new ArrayList<>();

	@OneToMany(mappedBy = "packages")
	private List<PackageLocations> packagelocations = new ArrayList<>();
}
