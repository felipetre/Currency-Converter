package com.felipe.demo;

public class Country {
	
	public String name;
	private String code;
	
	public Country(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + "]";
	}
	
	

}
