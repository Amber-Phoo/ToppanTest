package com.toppan.demo.dto;

import java.util.List;

public class BookDTO {
	public String name;
	public String author;
	public List<String> borrower;

	public BookDTO() {

	}

	public BookDTO(String name, String author, List<String> borrower) {
		this.name = name;
		this.author = author;
		this.borrower = borrower;
	}

}
