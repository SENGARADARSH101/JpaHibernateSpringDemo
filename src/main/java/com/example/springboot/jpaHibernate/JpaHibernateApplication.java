package com.example.springboot.jpaHibernate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.jpaHibernate.entiites.Course;
import com.example.springboot.jpaHibernate.entiites.FullTimeEmployee;
import com.example.springboot.jpaHibernate.entiites.PartTimeEmployee;
import com.example.springboot.jpaHibernate.entiites.Review;
import com.example.springboot.jpaHibernate.repose.CourseRepository;
import com.example.springboot.jpaHibernate.repose.EmployeeRepository;
import com.example.springboot.jpaHibernate.repose.StudentRepository;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repo;
	
	@Autowired
	StudentRepository stdrepo;

	@Autowired
	EmployeeRepository emprepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = repo.findById(10002L);
		
//	logger.info("course ->{}",course);
//		repo.deleteById(10001l);
//		repo.save(new Course("Algebra"));
	//	repo.saveStudentWithPassport();
	
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("2","Awesome"));
//		reviews.add(new Review("5","jdnkj"));
//		repo.addReviewsForCourse(10001L,reviews);
//		
//		repo.retrieve_reviews();
//		emprepo.insert(new FullTimeEmployee("Jack",new BigDecimal("100000")));
//		emprepo.insert(new PartTimeEmployee("Jill",new BigDecimal("50")));
//		
//		logger.info("All PartEmployess -> {}",emprepo.retrievePartTime());
//		logger.info("All FullEmployess -> {}",emprepo.retrieveFulltTime());
}

}
