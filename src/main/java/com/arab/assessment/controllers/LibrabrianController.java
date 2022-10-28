package com.arab.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arab.assessment.entities.Book;
import com.arab.assessment.repository.BookRepository;

@RestController
public class LibrabrianController {
	
	@Autowired
	BookRepository bookRepository;
	
	@PostMapping("/books/uploadBook")
	public String uploadBook(@RequestBody Book book) {
		bookRepository.save(book);
		return book.getTitle() + " saved successfully";
	}
	
	@PutMapping("/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
		Book existingBook = bookRepository.findById(id).get();
		bookRepository.save(book);
	}
	
	@GetMapping("/books/checkedout")
	public void checkedOutBooks() {}
	
	public void readersDetail() {}
	
	
	
}
