package com.toppan.demo.service;

import java.util.List;
import java.util.Optional;

import com.toppan.demo.domain.Book;
import com.toppan.demo.dto.BookDTO;

public interface BookService {

	public void saveBook(Book book);

	public List<Book> getAllBooks();

	public Optional<Book> findById(Integer Id);

	public List<Book> findByName(String name);

	public void deleteById(Integer id);

	public List<BookDTO> getTop3ReadBookGlobal();

	public List<BookDTO> getTop3ReadBookByCountry(String countryCode);
}
