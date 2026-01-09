package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Destinations;

public interface DestinationsRepo extends JpaRepository<Destinations, Long> {

}
