package com.example.springboot.jpaHibernate.repose;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.jpaHibernate.entiites.Course;

public interface CourseSpringDataRepository  extends JpaRepository<Course,Long>{

	
	
	
}
