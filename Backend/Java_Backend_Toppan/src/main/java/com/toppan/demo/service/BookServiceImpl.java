package com.toppan.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppan.demo.domain.Book;
import com.toppan.demo.dto.BookDTO;
import com.toppan.demo.dto.IBookAuthor;
import com.toppan.demo.repository.BookRepository;
import com.toppan.demo.util.CountryHelper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PeopleService peopleService;

	@Autowired
	AuthorBookService authorBookService;

	@Autowired
	BookRentService bookRentService;

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

	public List<BookDTO> getTop3ReadBookGlobal() {
		List<BookDTO> results = new ArrayList<BookDTO>();
		List<Integer> bookIds = bookRentService.getTop3Books();
		List<IBookAuthor> authorBooks = authorBookService.getBookAuthorByBookId(bookIds);
		// to remove a book with more than 1 author
		Collection<IBookAuthor> Unique_authorBooks = authorBooks.stream().collect(Collectors
				.toMap(IBookAuthor::getBookName, Function.identity(), (AuthorBook1, AuthorBook2) -> AuthorBook1))
				.values();

		for (IBookAuthor b : Unique_authorBooks) {
			List<Integer> personIds = bookRentService.getTop3RenterByBookId(b.getBookId());
			List<String> personNames = new ArrayList<String>();
			for(Integer i : personIds) {
				String name=peopleService.getPersonNameById(i);
				personNames.add(name);
			}
			BookDTO bookDto = new BookDTO();
			bookDto.name = b.getBookName();
			bookDto.author = b.getAuthorName();
			bookDto.borrower = personNames;
			results.add(bookDto);
			System.out.println(bookDto);
		}
		return results;
	}

	public List<BookDTO> getTop3ReadBookByCountry(String countryCode) {
		List<BookDTO> results = new ArrayList<BookDTO>();
		Integer countryId = new CountryHelper().GetCountryId(countryCode);
		System.out.println("CountryId :" + countryId);
		List<Integer> personIds = peopleService.getPersonIdsByCountryId(countryId);
		System.out.println(personIds);
		
		List<Integer> bookIds = bookRentService.getTop3BooksByPersonIds(personIds);
		List<IBookAuthor> authorBooks = authorBookService.getBookAuthorByBookId(bookIds);
		// to remove a book with more than 1 author
		Collection<IBookAuthor> Unique_authorBooks = authorBooks.stream().collect(Collectors
				.toMap(IBookAuthor::getBookName, Function.identity(), (AuthorBook1, AuthorBook2) -> AuthorBook1))
				.values();

		for (IBookAuthor b : Unique_authorBooks) {
			List<Integer> topRenterIds = bookRentService.getTop3RenterByBookIdAndPersonIds(b.getBookId(),personIds);
			List<String> personNames = new ArrayList<String>();
			for(Integer i : topRenterIds) {
				String name=peopleService.getPersonNameById(i);
				personNames.add(name);
			}
			BookDTO bookDto = new BookDTO();
			bookDto.name = b.getBookName();
			bookDto.author = b.getAuthorName();
			bookDto.borrower = personNames;
			results.add(bookDto);
			System.out.println(bookDto);
		}
		return results;
	}

}