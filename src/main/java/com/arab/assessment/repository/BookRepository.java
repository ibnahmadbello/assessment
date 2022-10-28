package com.arab.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arab.assessment.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
