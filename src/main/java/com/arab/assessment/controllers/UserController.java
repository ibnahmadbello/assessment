package com.arab.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arab.assessment.entities.Role;
import com.arab.assessment.entities.User;
import com.arab.assessment.repository.RoleRepository;
import com.arab.assessment.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/addlibrarian")
	public String registerLibrarian(@RequestBody User user) {
		Role librarianRole = roleRepository.findByName("admin");
		user.addRole(librarianRole);
		encodePassword(user);
		userRepository.save(user);
		return "Librarian profile created successfully";
	}
	
	@PostMapping("/addreader")
	public String registerReader(@RequestBody User user) {
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
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
}
