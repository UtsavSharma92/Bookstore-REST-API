package com.bookstore.springboot.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.springboot.books.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
