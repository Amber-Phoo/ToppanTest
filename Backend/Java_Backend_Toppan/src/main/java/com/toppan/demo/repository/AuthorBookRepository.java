package com.toppan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toppan.demo.domain.AuthorBook;
import com.toppan.demo.domain.AuthorBookKey;

@Repository
public interface AuthorBookRepository extends JpaRepository<AuthorBook, AuthorBookKey> {


}
