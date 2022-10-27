package com.arab.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arab.assessment.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT user FROM User WHERE user.email = ?1")
	public User findByEmail(String email);
	
}