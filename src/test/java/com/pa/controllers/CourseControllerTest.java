package com.pa.controllers;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.Test;

import com.pa.domain.Course;
import com.pa.repository.impl.CourseRepositoryImpl;

public class CourseControllerTest {

	CourseRepositoryImpl courseRepositoryImpl = new CourseRepositoryImpl(); 
	
	@Test
	public void shouldAddCourse() {
		CourseController courseController = new CourseController(courseRepositoryImpl);
		
		Course course = new Course("Ayr", "3m");
		courseController.addCourse(course);
		
		List<Course> courses = (List<Course>) courseRepositoryImpl.findAll();
		assertThat(courses.size(), equalTo(1));
	}
	
	@Test
	public void shouldGetAllCourses() {
		CourseController courseController = new CourseController(courseRepositoryImpl);
		
		Course course = new Course("Ayr", "3m");
		courseController.addCourse(course);
		
		course = new Course("Doncaster", "2m");
		courseController.addCourse(course);
		
		List<Course> courses = courseController.getAll();
		assertThat(courses.size(), equalTo(2));
	}
	
	@Test
	public void shouldGetCourseByName() {
		CourseController courseController = new CourseController(courseRepositoryImpl);
		
		Course course = new Course("Ayr", "3m");
		courseController.addCourse(course);
		
		course = new Course("Doncaster", "2m");
		courseController.addCourse(course);
		
		Course retrieved = courseController.getCourse("Doncaster");
		assertThat(retrieved.getName(), equalTo("Doncaster"));
		assertThat(retrieved.getDistance(), equalTo("2m"));
	}
	
	@Test
	public void shouldDeleteCourse() {
		CourseController courseController = new CourseController(courseRepositoryImpl);
		
		Course course = new Course("Ayr", "3m");
		courseController.addCourse(course);
		
		course = new Course("Doncaster", "2m");
		courseController.addCourse(course);
		
		List<Course> courses = courseController.getAll();
		assertThat(courses.size(), equalTo(2));
		
		courseController.deleteCourse(course);
		
		courses = courseController.getAll();
		assertThat(courses.size(), equalTo(1));
		
		Course retrieved = courses.get(0);
		assertThat(retrieved.getName(), equalTo("Ayr"));
		assertThat(retrieved.getDistance(), equalTo("3m"));
		
	}

	@Test
	public void shouldUpdateCourse() {
		CourseController courseController = new CourseController(courseRepositoryImpl);
		
		Course course = new Course("Ayr", "3m");
		courseController.addCourse(course);
		
		course = new Course("Doncaster", "2m");
		courseController.addCourse(course);
		
		List<Course> courses = courseController.getAll();
		assertThat(courses.size(), equalTo(2));
		
		course = new Course("Doncaster", "5m");
		
		courseController.updateCourse(course);
		
		courses = courseController.getAll();
		assertThat(courses.size(), equalTo(2));
		
		Course retrieved = courseController.getCourse("Doncaster");
		assertThat(retrieved.getDistance(), equalTo("5m"));
		
	}

	
}
