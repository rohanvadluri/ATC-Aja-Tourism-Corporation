package com.aja.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aja.entity.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, Long> {

	@Query("FROM Payments e WHERE e.isFlag = true")
	List<Payments> getFetchInfo();

	@Query("FROM Payments e WHERE e.isFlag = true AND e.paymentId = :epaymentId")
	Optional<Payments> getSpecificId(@Param("epaymentId") int epaymentId);

}
