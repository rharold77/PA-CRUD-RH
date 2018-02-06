package com.pa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pa.domain.Course;
import com.pa.repository.CourseRepository;

@RestController
@RequestMapping("/pa/course")
public class CourseController {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Course> getAll() {
        return (List<Course>) courseRepository.findAll();
    }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String name) {
        return courseRepository.findByName(name);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCourse(@RequestBody Course course) {
        courseRepository.delete(course);
    }
}
