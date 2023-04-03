/**
 * 
 */
package com.toppan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.toppan.demo.domain.Book;
import com.toppan.demo.service.BookService;

@RestController
@RequestMapping
public class MyRestController {
	protected final String blockMessage = "{\"Error\": \"You do not have permission to access this page.\"}";

	@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String defaultBlocker() {
		return blockMessage;
	}

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}

	@GetMapping("/install")
	public String install() {
		/*
		 * Book book1 = new Book("C#"); bookService.saveBook(book1);
		 */
		Book book2 = new Book("Java");
		bookService.saveBook(book2);
		Book book3 = new Book("React");
		bookService.saveBook(book3);
		Book book4 = new Book("Angular");
		bookService.saveBook(book4);
		Book book5 = new Book("Nodejs");
		bookService.saveBook(book5);
		Book book6 = new Book("Docker");
		bookService.saveBook(book6);
		return "{ \"Result\": \"OK\" }";
	}

}
