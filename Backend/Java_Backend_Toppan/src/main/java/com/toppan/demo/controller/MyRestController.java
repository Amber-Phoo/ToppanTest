/**
 * 
 */
package com.toppan.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toppan.demo.domain.Author;
import com.toppan.demo.domain.AuthorBook;
import com.toppan.demo.domain.AuthorBookKey;
import com.toppan.demo.domain.Book;
import com.toppan.demo.domain.BookRent;
import com.toppan.demo.domain.Country;
import com.toppan.demo.domain.People;
import com.toppan.demo.dto.BookDTO;
import com.toppan.demo.dto.CountryDTO;
import com.toppan.demo.dto.IBookAuthor;
import com.toppan.demo.service.AuthorBookService;
import com.toppan.demo.service.AuthorService;
import com.toppan.demo.service.BookRentService;
import com.toppan.demo.service.BookService;
import com.toppan.demo.service.PeopleService;
import com.toppan.demo.util.CountryHelper;

@RestController
@RequestMapping
public class MyRestController {
	protected final String blockMessage = "{\"Error\": \"You do not have permission to access this page.\"}";
	protected final String errorMessage = "{\"message\": \"invalid parameter\"}";
	protected final String notFoundMessage = "{\"message\": \"no results\"}";
	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@Autowired
	PeopleService peopleService;

	@Autowired
	AuthorBookService authorBookService;

	@Autowired
	BookRentService bookRentService;

	@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String defaultBlocker() {
		return blockMessage;
	}

	@GetMapping("/getTop3ReadBooks")
	public ResponseEntity<?> getTop3ReadBooks(@RequestParam(required = false) String country_code) {

		if (country_code != null) {
			if (CountryHelper.ValidateCountryCode(country_code))
				return new ResponseEntity<>(bookService.getTop3ReadBookGlobal(), HttpStatus.OK);
			else
				return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(bookService.getTop3ReadBookGlobal(), HttpStatus.OK);
		}

	}

	@GetMapping("/install")
	public String install() {
		/*
		 * Book book1 = new Book("C#"); bookService.saveBook(book1);
		 * 
		 * Book book2 = new Book("Java"); bookService.saveBook(book2); Book book3 = new
		 * Book("React"); bookService.saveBook(book3); Book book4 = new Book("Angular");
		 * bookService.saveBook(book4); Book book5 = new Book("Nodejs");
		 * bookService.saveBook(book5); Book book6 = new Book("Docker");
		 * bookService.saveBook(book6);
		 * 
		 * 
		 * Author author = new Author("Bed"); authorService.saveAuthor(author); Author
		 * author2 = new Author("Kino"); authorService.saveAuthor(author2); Author
		 * author3 = new Author("Pribuck"); authorService.saveAuthor(author3);
		 * 
		 * AuthorBook authorBook=new AuthorBook(new AuthorBookKey(9,3));
		 * authorBookService.saveAuthorBook(authorBook); AuthorBook authorBook2=new
		 * AuthorBook(new AuthorBookKey(10,4));
		 * authorBookService.saveAuthorBook(authorBook2); AuthorBook authorBoo3=new
		 * AuthorBook(new AuthorBookKey(11,5));
		 * authorBookService.saveAuthorBook(authorBoo3);
		 * 
		 * People people = new People("John", 1); peopleService.savePeople(people);
		 * People people2 = new People("Mike", 1); peopleService.savePeople(people2);
		 * People people3 = new People("Jos", 1); peopleService.savePeople(people3);
		 */

//		People people = new People("May", 2);
//		peopleService.savePeople(people);
//		People people2 = new People("June", 3);
//		peopleService.savePeople(people2);
//		People people3 = new People("April", 4);
//		peopleService.savePeople(people3);

//		BookRent bookRent = new BookRent(5, 12);
//		bookRentService.saveBookRent(bookRent);
//		BookRent bookRent2 = new BookRent(5, 12);
//		bookRentService.saveBookRent(bookRent2);
//		BookRent bookRent3 = new BookRent(3, 11);
//		bookRentService.saveBookRent(bookRent3);

		return "{ \"Result\": \"OK\" }";
	}

	@GetMapping("/getRandomCountry")
	public ResponseEntity<?> getRandomCountry() {
		try {
			List<Country> countryList = CountryHelper.getCountryList();
			Random random = new Random();
			Country c = countryList.get(random.nextInt(countryList.size() - 1));
			return new ResponseEntity<>(new CountryDTO().ConvertDTO(c), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
