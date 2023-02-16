package com.example.springboot.jpaHibernate.entiites;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable =false)
	private String number;
	
	protected Passport()
	{
		
	}
	
	public Passport(String number)
	{
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return number;
	}

	public void setName(String name) {
		this.number = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + "]";
	}
	
	
}
