package com.bookstore.springboot.books.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_details")
public class Books {

	@Id
	@Column(name = "isbn")
	private int isbn;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "description")
	private String description;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "release_date")
	private Date date;

	@Column(name = "price")
	private double price;

	public Books() {

	}

	public Books(int isbn, String bookName, String description, String authorName, Date date, double price) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.description = description;
		this.authorName = authorName;
		this.date = date;
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", bookName=" + bookName + ", description=" + description + ", authorName="
				+ authorName + ", date=" + date + ", price=" + price + "]";
	}

}
