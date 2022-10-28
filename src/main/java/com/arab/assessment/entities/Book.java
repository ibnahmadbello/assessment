package com.arab.assessment.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private String id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(nullable = false, name = "revision_number")
	private String revisionNumber;
	
	@Column(nullable = false, name = "published_date")
	private Date publishedDate;
	
	@Column(nullable = false)
	private String publisher;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false, name = "date_added")
	private Date dateAdded;
	
	@Column(nullable = false)
	private String genre;
	
	@Lob
	@Column(name = "cover_image")
	private byte[] coverImage;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevision_number(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	//TODO-- author (or authors)

}
