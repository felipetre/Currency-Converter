package com.felipe.demo;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Values {
	
	
	String name;
	String name2;
	@Nonnull
	@Pattern(regexp = "^[0-9]*$", message = "Input is not a number!")
	String value;
	//double value;
	
	public Values( String name, String name2, String value /*double value*/) {
		
		this.name = name;
		
		this.name2 = name2;
		
		this.value = value;
	}
	
	
	  public String getValue() { return value; }
	  
	  public void setValue(String value) { this.value = value; }
	 
	
	/*
	 * public double getValue() { return value; }
	 * 
	 * public void setValue(double value) { this.value = value; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getname2() {
		return name2;
	}

	public void setname2(String name2) {
		this.name2 = name2;
	}
	
	

}
