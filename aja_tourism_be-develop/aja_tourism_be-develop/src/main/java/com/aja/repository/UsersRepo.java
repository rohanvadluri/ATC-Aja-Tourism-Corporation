package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{
	
	boolean existsByEmail(String email);
	 Users findByEmail(String email);

}
