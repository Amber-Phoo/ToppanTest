package com.toppan.demo.service;

import java.util.List;

import com.toppan.demo.domain.BookRent;

public interface BookRentService {
	public void saveBookRent(BookRent bookRent);
	
	public List<Integer> getTop3Books();
	
	public List<Integer> getTop3RenterByBookId(Integer id);
	
	public List<Integer> getTop3BooksByPersonIds(List<Integer> personIds);
	
	public List<Integer> getTop3RenterByBookIdAndPersonIds(Integer id,List<Integer> personIds);
}
