package com.example.springboot.jpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.springboot.jpaHibernate.entiites.Address;
import com.example.springboot.jpaHibernate.entiites.Course;
import com.example.springboot.jpaHibernate.entiites.Passport;
import com.example.springboot.jpaHibernate.entiites.Student;
import com.example.springboot.jpaHibernate.repose.CourseRepository;
import com.example.springboot.jpaHibernate.repose.CourseSpringDataRepository;
import com.example.springboot.jpaHibernate.repose.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@SpringBootTest
class CourseSpringTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());	
	@Autowired
	CourseSpringDataRepository repo;
	
	
	@Autowired
	CourseRepository crepo;
	

	@Autowired
	StudentRepository srepo;
	
	
	
	@Autowired
	EntityManager em;
	
	@Test
	public void findById()
	{
		Optional<Course> cop = repo.findById(10001L);
		logger.info("{}",cop.isPresent());
		
	}
	
	@Test
	@DirtiesContext
	public void delete_basic()
	{
		crepo.deleteById(10001l);
		assertNull(crepo.findById(10001l));
		
	
	}
	
	
	@Test
	@Transactional
	public void setAddressDetails()
	{
		Student std = em.find(Student.class, 20001l);
		
		std.setAddress(new Address("Ganga","Ganj","Knpaur"));
		em.flush();
		
		logger.info("Student -> {}",std);
		
		
	}
	

}
