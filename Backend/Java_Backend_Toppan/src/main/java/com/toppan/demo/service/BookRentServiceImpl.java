package com.toppan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppan.demo.domain.BookRent;
import com.toppan.demo.repository.BookRentRepository;

@Service
public class BookRentServiceImpl implements BookRentService {

	@Autowired
	BookRentRepository bookRentRepository;

	public void saveBookRent(BookRent book) {
		bookRentRepository.save(book);
	}
	
	public List<Integer> getTop3Books(){
		return bookRentRepository.getTop3Books();
	}

}
