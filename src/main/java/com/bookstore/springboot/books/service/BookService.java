package com.bookstore.springboot.books.service;

import java.util.List;

import com.bookstore.springboot.books.entity.Books;

public interface BookService {

	public List<Books> findAll();

	public Books findById(int theId);

	public void save(Books theEmployee);

	public void deleteById(int theId);

}
