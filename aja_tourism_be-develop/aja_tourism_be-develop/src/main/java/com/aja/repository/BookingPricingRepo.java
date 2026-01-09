package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.BookingPricing;
@Repository
public interface BookingPricingRepo extends JpaRepository<BookingPricing, Long> {

}
