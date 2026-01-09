package com.aja.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class States {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stateId;
	private String stateName;
	private boolean isFlag=true;
	
//	Relationships

	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	private List<Places> places = new ArrayList<>();

	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	private List<Packages> packages = new ArrayList<>();
}
