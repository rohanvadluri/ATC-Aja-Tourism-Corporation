package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PackageLocations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;

//	Relationships

	@ManyToOne
	@JoinColumn(name = "place_id")
	private Places place;

	@ManyToOne
	@JoinColumn(name = "package_id")
	private Packages packages;
}
