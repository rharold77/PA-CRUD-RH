package com.pa.repository;

import org.springframework.data.repository.CrudRepository;

import com.pa.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	public Course findByName(String name);
	
}
