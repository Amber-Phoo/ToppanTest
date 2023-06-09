package com.toppan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppan.demo.domain.AuthorBook;
import com.toppan.demo.dto.IBookAuthor;
import com.toppan.demo.repository.AuthorBookRepository;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {

	@Autowired
	AuthorBookRepository authorBookRepository;

	public void saveAuthorBook(AuthorBook book) {
		authorBookRepository.save(book);
	}
	
	public List<IBookAuthor> getBookAuthorByBookId(List<Integer> bookIds){
		return authorBookRepository.getBookAuthorByBookId(bookIds);
	}

}