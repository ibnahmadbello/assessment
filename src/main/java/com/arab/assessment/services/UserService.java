package com.arab.assessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arab.assessment.entities.Role;
import com.arab.assessment.entities.User;
import com.arab.assessment.repository.RoleRepository;
import com.arab.assessment.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String registerLibrarian(User user) {
		Role librarianRole = roleRepository.findByName("admin");
		user.addRole(librarianRole);
		encodePassword(user);
		userRepository.save(user);
		return "Librarian profile created successfully";
	}
	
	public String registerReader(User user) {
		Role readerRole = roleRepository.findByName("reader");
		user.addRole(readerRole);
		encodePassword(user);
		userRepository.save(user);
		return "Reader profile created successfully";
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
	
}
