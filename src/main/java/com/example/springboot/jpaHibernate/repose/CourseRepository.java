package com.example.springboot.jpaHibernate.repose;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.jpaHibernate.entiites.Course;
import com.example.springboot.jpaHibernate.entiites.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id) {
		
		return em.find(Course.class, id);
		
	}
	
	public Course save(Course course)
	{
		if(course.getId()<0)
		{
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		return course;
	}
//	
	public void deleteById(Long id)
	{
		em.remove(this.findById(id));
		
	}
	public void exp_entityManager()
	{
		Course course1 = new Course("Algebra");
		em.persist(course1);
		
		Course course2 = findById(10002L); 
		course2.setName("SST");
		
	}
	
	public void addReviewsForCourse(Long Course_id, List<Review> reviews)
	{
		Course cr = findById(Course_id);
		logger.info("Course is -> {}",cr.getReviews());
		
		for(Review review:reviews)
		{
			review.setCourse(cr);
			cr.addReviews(review);
			em.persist(review);
		}
		
	
	
		logger.info("Course is -> {}",cr.getReviews());
		
	}
	public void retrieve_reviews()
	{
		Course cr = findById(10002L);
		logger.info("Course reviews are -> {}",cr.getReviews());
	}
//	
}
