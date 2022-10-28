package com.arab.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arab.assessment.entities.Role;
import com.arab.assessment.entities.User;
import com.arab.assessment.repository.RoleRepository;
import com.arab.assessment.repository.UserRepository;
import com.arab.assessment.services.SecurityService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	SecurityService securityService;
	
	@PostMapping("/addlibrarian")
	public ResponseEntity<String> registerLibrarian(@RequestBody User user) {
		Role librarianRole = roleRepository.findByName("admin");
		user.addRole(librarianRole);
		encodePassword(user);
		userRepository.save(user);
		return new ResponseEntity<>("Librarian profile created successfully", HttpStatus.OK);
	}
	
	@PostMapping("/addreader")
	public ResponseEntity<String> registerReader(@RequestBody User user) {
		Role readerRole = roleRepository.findByName("reader");
		user.addRole(readerRole);
		encodePassword(user);
		userRepository.save(user);
		return new ResponseEntity<>("Reader profile created successfully", HttpStatus.OK);
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping("/login")
	public String login(@RequestBody String email, String password) {
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "Login Successfully";
		} else {
			return "Invalid email or password";
		}
		
	}
	
	
	
}
