package com.toppan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toppan.demo.domain.AuthorBook;
import com.toppan.demo.domain.AuthorBookKey;
import com.toppan.demo.dto.IBookAuthor;

@Repository
public interface AuthorBookRepository extends JpaRepository<AuthorBook, AuthorBookKey> {

	@Query("SELECT b.name as bookName, b.id as bookId, a.name as authorName"
			+ "	FROM AuthorBook ab, Author a, Book b where ab.id.authorId=a.id and ab.id.bookId=b.id and ab.id.bookId in (?1)")
	public List<IBookAuthor> getBookAuthorByBookId(List<Integer> bookIds);
}
