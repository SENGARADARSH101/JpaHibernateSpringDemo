package com.example.springboot.jpaHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.springboot.jpaHibernate.entiites.Course;
import com.example.springboot.jpaHibernate.entiites.Passport;
import com.example.springboot.jpaHibernate.entiites.Student;
import com.example.springboot.jpaHibernate.repose.CourseRepository;
import com.example.springboot.jpaHibernate.repose.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@SpringBootTest
class JpaHibernateApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());	
	@Autowired
	CourseRepository repo;
	
	@Autowired
	StudentRepository std_repo;
	
	
	@Autowired
	EntityManager em;
	
	
	@Test
	public void testfindById() {
		assertEquals("Mathematics",repo.findById(10001L).getName());
		
	}
	
	@Test
	@DirtiesContext
	public void deleteById()
	{
		repo.deleteById(10002L);
		assertNull(repo.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void testsaved()
	{
		assertEquals("Hello",repo.save(new Course("Hello")).getName());
		
	}
	
	@Test
	public void jpqltest() {

		 TypedQuery<Course> query = 
		em.createQuery("Select c from Course c",Course.class);
		
		 List<Course> rs = query.getResultList();
		 
		 logger.info("Select c from course c -> {}", rs);
		 
		

	}
	
	@Test
	public void native_query_basic()
	{
		Query query = em.createNativeQuery("Select * from Course",Course.class);
		List rs = query.getResultList();
		
		logger.info("Course list are -> {}",rs);
		
	}
	
	
	@Test
	public void retrieveStudentAndPassportDetails()
	{
		
		Student std1 = em.find(Student.class,20001l);
		logger.info("Student details -> {}",std1);
	///	logger.info("Student details -> {}",std1.getPassport());

		
		
	}
	
	
	@Test
	@Transactional
	public void someTest()
	{
		
		Student std = em.find(Student.class, 20001);
		
		Passport pp = std.getPassport();
		
		pp.setName("E2493903");
		
		std.setName("Hello - updated");
			
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses()
	{
		
		Student std = em.find(Student.class, 20001);
		
		logger.info("student ->{}",std);
		logger.info("course ->{}",std.getCourses());
		
			
	}
	
	
	@Test
	public void jpql_without_students()
	{
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty",
				Course.class);
		List<Course> rs = query.getResultList();
		
		logger.info("Results -> {}", rs);
		
	}
	
	@Test
	public void jpql_with_2_students()
	{
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students)>=2",
				Course.class);
		List<Course> rs = query.getResultList();
		
		logger.info("Results -> {}", rs);
		
	}
	@Test
	public void jpql_order_by_students()
	{
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students)",
				Course.class);
		List<Course> rs = query.getResultList();
		
		logger.info("Results -> {}", rs);
		
	}

	
	@Test
	public void criteriaq()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		Root<Course> root = cq.from(Course.class);
		
		TypedQuery<Course> qr = em.createQuery(cq.select(root));
		
		List<Course> rs = qr.getResultList();
		
		logger.info("COurses -> {}",rs);
		
		
		
		
		
		
		
		
	}
	

}
