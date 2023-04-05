package com.toppan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toppan.demo.domain.BookRent;

@Repository
public interface BookRentRepository extends JpaRepository<BookRent, Integer> {

	@Query("SELECT book_id FROM BookRent group by book_id order by Count(book_id) desc limit 3")
	List<Integer> getTop3Books();

}