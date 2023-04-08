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
	
	public List<Integer> getTop3RenterByBookId(Integer id){
		return bookRentRepository.getTop3RenterByBookId(id);
	}

	public List<Integer> getTop3BooksByPersonIds(List<Integer> personIds) {
		return bookRentRepository.getTop3BooksByPersonIds(personIds);
	}

	public List<Integer> getTop3RenterByBookIdAndPersonIds(Integer id, List<Integer> personIds) {
		return bookRentRepository.getTop3RenterByBookIdAndPersonIds(id,personIds);
	}

}
