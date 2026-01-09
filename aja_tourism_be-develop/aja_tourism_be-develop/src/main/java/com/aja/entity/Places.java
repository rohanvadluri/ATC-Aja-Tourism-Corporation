package com.aja.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Setter
@Getter
public class Places {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeId;

	private String placeName;

	private String description;

//	@Column(name = "is_flag", nullable = false)
	private Boolean isFlag = true;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private States state;

	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
	private List<PackageLocations> packageLocations = new ArrayList<>();
	
	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
	private List<Destinations> destinations = new ArrayList<>();


}
