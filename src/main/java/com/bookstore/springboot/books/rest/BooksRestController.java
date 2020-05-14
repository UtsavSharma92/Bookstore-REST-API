package com.bookstore.springboot.books.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.springboot.books.entity.Books;
import com.bookstore.springboot.books.service.BookService;

@RestController
public class BooksRestController {

	private BookService bookService;

	public BooksRestController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public List<Books> findAll() {
		return bookService.findAll();

	}

	@GetMapping("/books/{isbn}")
	public Books getBooksById(@PathVariable int isbn) {

		Books books = bookService.findById(isbn);
		if (books == null) {

			throw new RuntimeException("Book with entered isbn not found -" + isbn);
		}

		return books;

	}

	@PostMapping("/books")
	public Books addBook(@RequestBody Books books) {

System.out.println("Printing something");
System.out.println("Print statement");
		System.out.println("ISBN number :" + books.getIsbn());

		if (books.getIsbn() == 0)
			throw new RuntimeException("Please enter an ISBN number");
		
		int length = String.valueOf(books.getIsbn()).length();
		
		boolean numeric = true;

        try {
            Double num = Double.parseDouble(String.valueOf(books.getIsbn()));
            
        } catch (NumberFormatException e) {
            numeric = false;
        }

        if(!numeric)
            System.out.println("Entered isbn is not a number");
        		
		if(length != 10)
			throw new RuntimeException("ISBN number should be of 10 digits");

		bookService.save(books);
		return books;

	}

	@PutMapping("/books")
	public Books updateBook(@RequestBody Books books) {

		bookService.save(books);
		return books;

	}

	@DeleteMapping("/books/{isbn}")
	public String deleteBook(@PathVariable int isbn) {

		Books tempBook = bookService.findById(isbn);

		if (tempBook == null) {
			throw new RuntimeException("Book with this isbn not found -" + isbn);
		}

		bookService.deleteById(isbn);
		return "Deleted isbn -" + isbn;

	}

}
