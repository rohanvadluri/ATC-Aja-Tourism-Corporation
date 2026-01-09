package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.States;
@Repository
public interface StatesRepo extends JpaRepository<States, Long>
{

	
	
//	@Query("FROM States s WHERE s.isFlag=true AND s.stateId=:stateId")
//	Optional<States> getSpecificId(@Param("stateId") Long stateId);
}
