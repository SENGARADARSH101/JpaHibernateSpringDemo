package com.example.springboot.jpaHibernate.entiites;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String line1;
	private String line2;
	private String City;
	
	protected Address()
	{
		
	}
	
	
	public Address(String line1, String line2, String city) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		City = city;
	}
	
	
	
	
}

