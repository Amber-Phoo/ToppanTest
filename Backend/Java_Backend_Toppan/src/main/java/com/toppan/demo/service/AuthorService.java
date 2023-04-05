package com.toppan.demo.service;

import java.util.List;
import java.util.Optional;

import com.toppan.demo.domain.Author;

public interface AuthorService {

	public void saveAuthor(Author author);

	public List<Author> getAllAuthors();

	public Optional<Author> findById(Integer Id);

	public List<Author> findByName(String name);

	public void deleteById(Integer id);

}
