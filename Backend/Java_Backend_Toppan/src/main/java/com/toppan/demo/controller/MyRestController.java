/**
 * 
 */
package com.toppan.demo.controller;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.toppan.demo.domain.Country;
import com.toppan.demo.dto.BookDTO;
import com.toppan.demo.dto.CountryDTO;
import com.toppan.demo.service.AuthorBookService;
import com.toppan.demo.service.AuthorService;
import com.toppan.demo.service.BookRentService;
import com.toppan.demo.service.BookService;
import com.toppan.demo.service.PeopleService;
import com.toppan.demo.util.CountryHelper;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class MyRestController {
	
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


	@GetMapping("/getTop3ReadBooks")
	public ResponseEntity<?> getTop3ReadBooks(@RequestParam(required = false) String country_code) {

		if (country_code != null) {
			if (new CountryHelper().ValidateCountryCode(country_code)) {
				List<BookDTO> bookList = bookService.getTop3ReadBookByCountry(country_code);
				return new ResponseEntity<>(bookList.size() > 0 ? bookList : notFoundMessage, HttpStatus.OK);
			} else
				return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		} else {
			List<BookDTO> bookList = bookService.getTop3ReadBookGlobal();
			return new ResponseEntity<>(bookList.size() > 0 ? bookList : notFoundMessage, HttpStatus.OK);
		}

	}

	@GetMapping("/install")
	public String install() {
		return "{ \"Result\": \"OK\" }";
	}

	@GetMapping("/getRandomCountry")
	public ResponseEntity<?> getRandomCountry() {
		try {
			List<Country> countryList = new CountryHelper().getCountryListUpdate();
			Random random = new Random();
			Country c = countryList.get(random.nextInt(countryList.size() - 1));
			//Country c = countryList.get(random.nextInt(2));
			return new ResponseEntity<>(new CountryDTO().ConvertDTO(c), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
