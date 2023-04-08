package com.toppan.demo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toppan.demo.domain.Country;
import com.toppan.demo.dto.CountryDTO;

public class CountryHelper {

	
	@Autowired
	ResourceLoader resourceLoader;
	
	public CountryHelper() {

	}

	public Boolean ValidateCountryCode(String countryCode) {
		List<Country> countryList = getCountryListUpdate();
		return countryList.stream().anyMatch(p -> p.getCode().equals(countryCode));
	}

	public Integer GetCountryId(String countryCode) {
		Integer countryId = 0;
		List<Country> countryList = getCountryListUpdate();
		for (int i = 0; i < countryList.size(); i++) {

			if (countryList.get(i).getCode().equals(countryCode)) {
				System.out.println(countryList.get(i).getCode() + "," + countryCode);
				countryId = i + 1;
				break;
			}
		}
		return countryId;
	}

//	public static List<Country> getCountryList() {
//		try {
//			File file = ResourceUtils.getFile("classpath:lesscountry.json");
//			ObjectMapper objectMapper = new ObjectMapper();
//			List<Country> countryList = objectMapper.readValue(file, new TypeReference<List<Country>>() {
//			});
//			return countryList;
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}

	public List<Country> getCountryListUpdate() {
		try {
			InputStream file = getClass().getResourceAsStream("/lesscountry.json");

			ObjectMapper objectMapper = new ObjectMapper();
			List<Country> countryList = objectMapper.readValue(file, new TypeReference<List<Country>>() {
			});
			return countryList;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
