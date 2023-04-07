package com.toppan.demo.dto;

import com.toppan.demo.domain.Country;

public class CountryDTO {

	public C1 country;

	public CountryDTO() {

	}

	public CountryDTO(C1 country) {
		this.country = country;
	}

	public CountryDTO ConvertDTO(Country c) {
		C1 c1 = new C1(c.getName(), c.getCode());
		return new CountryDTO(c1);
	}

	public class C1 {
		public String full_name;
		public String country_code;

		public C1() {

		}

		public C1(String name, String code) {
			this.full_name = name;
			this.country_code = code;
		}

	}
}
