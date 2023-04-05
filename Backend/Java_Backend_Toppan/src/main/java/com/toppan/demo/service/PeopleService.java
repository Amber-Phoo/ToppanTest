package com.toppan.demo.service;

import java.util.List;
import java.util.Optional;

import com.toppan.demo.domain.People;

public interface PeopleService {

	public void savePeople(People people);

	public List<People> getAllPeople();

	public Optional<People> findById(Integer Id);

	public List<People> findByName(String name);

	public void deleteById(Integer id);

}