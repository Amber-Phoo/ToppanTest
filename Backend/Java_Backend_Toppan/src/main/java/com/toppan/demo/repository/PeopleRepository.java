package com.toppan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toppan.demo.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

	@Query("SELECT name" + "	FROM People where id in (?1)")
	public List<String> getPersonNamesByIds(List<Integer> peopleIds);

	@Query("SELECT id" + "	FROM People p where country_id=?1")
	public List<Integer> getPersonIdsByCountryId(Integer countryId);
	
	@Query("SELECT name" + "	FROM People where id=?1")
	public String getPersonNameById(Integer peopleId);
}
