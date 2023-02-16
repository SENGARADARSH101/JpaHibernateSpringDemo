package com.example.springboot.jpaHibernate.repose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.jpaHibernate.entiites.Passport;
import com.example.springboot.jpaHibernate.entiites.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public Student findById(Long id) {
		
		return em.find(Student.class, id);
		
	}
	
	public Student save(Student student)
	{
		if(student.getId()<0)
		{
			em.persist(student);
		}
		else {
			em.merge(student);
		}
		return student;
	}
//	
	public void deleteById(Long id)
	{
		em.remove(this.findById(id));
		
	}
	public void saveStudentWithPassport()
	{
		Passport pp = new Passport("Z123344");
		em.persist(pp);
		Student student1 = new Student("Mike");
		student1.setPassport(pp);
		em.persist(student1);
		
//		Student course2 = findById(10002L); 
//		course2.setName("SST");
		
	}
	
	
//	
}
