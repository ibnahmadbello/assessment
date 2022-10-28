package com.arab.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> uploadBook(@RequestBody Book book) {
		bookRepository.save(book);
		return new ResponseEntity<>(book.getTitle() + " saved successfully", HttpStatus.OK);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable Integer id) {
		Book existingBook = bookRepository.findById(id).get();
		bookRepository.save(book);
		return new ResponseEntity<>(existingBook.getTitle() + "Book updated successfully!", HttpStatus.OK);
	}
	
	@GetMapping("/books/checkedout")
	public void checkedOutBooks() {}
	
	public void readersDetail() {}
	
	
	
}
