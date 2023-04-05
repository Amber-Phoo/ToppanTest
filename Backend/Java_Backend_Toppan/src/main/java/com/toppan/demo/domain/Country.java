package com.toppan.demo.domain;

public class Country {

	public String name;
	public String code;
	public String dial_code;

	public Country() {
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + ", dial_code=" + dial_code + "]";
	}
}
