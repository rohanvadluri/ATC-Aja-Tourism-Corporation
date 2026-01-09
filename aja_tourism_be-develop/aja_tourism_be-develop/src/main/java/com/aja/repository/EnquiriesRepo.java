package com.aja.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aja.entity.Enquiries;

@Repository
public interface EnquiriesRepo extends JpaRepository<Enquiries, Long> {
	
	@Query("FROM Enquiries e WHERE e.isFlag = true")
    List<Enquiries> getFetchInfo();

    @Query("FROM Enquiries e WHERE e.isFlag = true AND e.enquiryId = :enquiryId")
    Optional<Enquiries> getSpecificId(@Param("enquiryId") int enquiryId);

}
