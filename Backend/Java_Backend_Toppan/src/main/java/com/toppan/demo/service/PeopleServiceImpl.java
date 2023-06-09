package com.toppan.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppan.demo.domain.People;
import com.toppan.demo.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	PeopleRepository peopleRepository;

	public void savePeople(People book) {
		peopleRepository.save(book);
	}

	public List<People> getAllPeople() {
		return peopleRepository.findAll();
	}

	public String getPersonNameById(Integer Id) {
		return peopleRepository.getPersonNameById(Id);
	}

	public void deleteById(Integer id) {
		peopleRepository.deleteById(id);
	}

	public List<String> getPersonNamesByIds(List<Integer> ids) {
		return peopleRepository.getPersonNamesByIds(ids);
	}

	public List<Integer> getPersonIdsByCountryId(Integer countryId) {
		// TODO Auto-generated method stub
		return peopleRepository.getPersonIdsByCountryId(countryId);
	}
}