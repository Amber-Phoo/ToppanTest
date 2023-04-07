package com.toppan.demo.domain;

public class Country {

	private String name;
	private String code;
	private String dial_code;
	
	public Country() {
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDial_code() {
		return dial_code;
	}



	public void setDial_code(String dial_code) {
		this.dial_code = dial_code;
	}



	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + ", dial_code=" + dial_code + "]";
	}
}
