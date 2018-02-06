package com.pa.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.pa.domain.Course;
import com.pa.repository.CourseRepository;

@Component
public class CourseRepositoryImpl implements CourseRepository {

	private static Map<String, Course> database = new HashMap<String, Course>();
	
	static {
		Course course = new Course("Market Rasen", "2m 148y");
		database.put(course.getName(), course);
		
		course = new Course("Southwell", "1m 13y");
		database.put(course.getName(), course);
	}
	
	@Override
	public <S extends Course> S save(S entity) {
		database.put(entity.getName(), entity);
		return entity;
	}

	@Override
	public <S extends Course> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Course> findAll() {
		List<Course> courses = new ArrayList<Course>();
		
		for (String key : database.keySet()) {
			courses.add(database.get(key));
		}
		
		return courses;
	}

	@Override
	public Iterable<Course> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course entity) {
		database.remove(entity.getName());
	}

	@Override
	public void delete(Iterable<? extends Course> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Course findByName(String name) {
		for (String key : database.keySet()) {
			if(key.equals(name)) {
				return database.get(key);
			}
		}
		return null;
	}

}
