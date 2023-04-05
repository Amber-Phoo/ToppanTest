package com.toppan.demo.service;

import java.util.List;

import com.toppan.demo.domain.BookRent;

public interface BookRentService {
	public void saveBookRent(BookRent bookRent);
	
	public List<Integer> getTop3Books();
}
