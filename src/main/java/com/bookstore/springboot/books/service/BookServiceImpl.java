package com.bookstore.springboot.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.springboot.books.dao.BooksRepository;
import com.bookstore.springboot.books.entity.Books;

@Service
public class BookServiceImpl implements BookService {

	private BooksRepository booksRepository;

	public BookServiceImpl(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	@Override
	@Transactional
	public List<Books> findAll() {
		// TODO Auto-generated method stub
		return booksRepository.findAll();
	}

	@Override
	public Books findById(int isbn) {
		Optional<Books> result = booksRepository.findById(isbn);
              
		System.out.println("book id :"+isbn);
		
		Books books = null;

		if (result.isPresent())
			books = result.get();
		else
			throw new RuntimeException("Did not find Book ISBN :" + isbn);

		return books;
	}

	@Override
	@Transactional
	public void save(Books theEmployee) {
		booksRepository.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		booksRepository.deleteById(theId);

	}

}
