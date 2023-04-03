package com.toppan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toppan.demo.domain.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query
    public List<Book> findByName(String name);

}
