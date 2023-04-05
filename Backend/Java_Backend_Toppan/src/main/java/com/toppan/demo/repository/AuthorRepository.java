package com.toppan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toppan.demo.domain.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query
    public List<Author> findByName(String name);

}
