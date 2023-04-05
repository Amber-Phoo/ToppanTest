package com.toppan.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AuthorBookKey implements Serializable {
	@Column(name = "book_id")
	private Integer bookId;

	@Column(name = "author_id")
	private Integer authorId;

	@Override
	public int hashCode() {
		return Objects.hash(authorId, bookId);
	}

	public AuthorBookKey() {
	}

	public AuthorBookKey(Integer bookId, Integer authorId) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorBookKey other = (AuthorBookKey) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(bookId, other.bookId);
	}

}
