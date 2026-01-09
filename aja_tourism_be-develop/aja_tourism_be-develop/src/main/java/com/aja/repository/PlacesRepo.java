package com.aja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.Places;

@Repository
public interface PlacesRepo extends JpaRepository<Places, Long> {

	boolean existsByPlaceNameIgnoreCase(String placeName);

	List<Places> findByIsFlagTrue();

	
}
