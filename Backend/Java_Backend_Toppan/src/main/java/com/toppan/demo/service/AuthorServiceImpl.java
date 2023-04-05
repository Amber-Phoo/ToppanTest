package com.toppan.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppan.demo.domain.Author;
import com.toppan.demo.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public void saveAuthor(Author book) {
		authorRepository.save(book);
	}

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public Optional<Author> findById(Integer Id) {
		return authorRepository.findById(Id);
	}

	public void deleteById(Integer id) {
		authorRepository.deleteById(id);
	}

	public List<Author> findByName(String name) {
		return authorRepository.findByName(name);
	}
}