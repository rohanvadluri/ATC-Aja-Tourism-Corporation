package com.aja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aja.entity.Packages;
import com.aja.entity.Testimonials;
@Repository
public interface PackagesRepo extends JpaRepository<Packages, Long> {
	List<Packages> findByIsFlagTrue();
}
