package com.example.springboot.jpaHibernate.entiites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class Employee {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	
	protected Employee()
	{
		
	}

	public Employee(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}


	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	
}
