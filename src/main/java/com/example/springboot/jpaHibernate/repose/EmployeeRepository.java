package com.example.springboot.jpaHibernate.repose;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.jpaHibernate.entiites.Employee;
import com.example.springboot.jpaHibernate.entiites.FullTimeEmployee;
import com.example.springboot.jpaHibernate.entiites.PartTimeEmployee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insert(Employee emp)
	{
		em.persist(emp);
	}
	
	public List<PartTimeEmployee> retrievePartTime()
	{
		return em.createQuery("Select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveFulltTime()
	{
		return em.createQuery("Select e from PartTimeEmployee e",FullTimeEmployee.class).getResultList();
	}
	
	
	
}
