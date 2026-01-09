package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.PackageLocations;

public interface PackageLocationsRepo extends JpaRepository<PackageLocations, Long> {

}
