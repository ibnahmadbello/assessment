package com.arab.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arab.assessment.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("SELECT role FROM Role WHERE role.name = ?1")
	public Role findByName(String name);

}
