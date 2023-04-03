package com.toppan.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppan.demo.domain.Book;
import com.toppan.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> findById(Integer Id) {
		return bookRepository.findById(Id);
	}

	public void deleteById(Integer id) {
		bookRepository.deleteById(id);
	}

	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}
}