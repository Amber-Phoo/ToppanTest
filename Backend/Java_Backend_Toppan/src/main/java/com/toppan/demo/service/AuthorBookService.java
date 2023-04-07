package com.toppan.demo.service;
import java.util.List;

import com.toppan.demo.domain.AuthorBook;
import com.toppan.demo.dto.IBookAuthor;

public interface AuthorBookService {

	public void saveAuthorBook(AuthorBook authorBook);

	public List<IBookAuthor> getBookAuthorByBookId(List<Integer> bookIds);
}