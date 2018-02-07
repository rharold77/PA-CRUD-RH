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
	
	/**
	 * Endpoint to get all course information
	 * 
	 * @return json array containing all course info
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Course> getAll() {
        return (List<Course>) courseRepository.findAll();
    }
	
	/**
	 * Endpoint to get a course based on the name
	 * 
	 * @param name the name of the course
	 * @return course object in json 
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String name) {
        return courseRepository.findByName(name);
    }
	
	/**
	 * Endpoint to add a course to the database.  The id will be
	 * auto generated.
	 * 
	 * @param course json object 
	 * @return the Course saved.
	 */
	@RequestMapping(method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
	
	/**
	 * Endpoint to update an existing course object.
	 * 
	 * @param course the course with id
	 * @return the course updated
	 */
	@RequestMapping(method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
	
	
	/**
	 * Endpoint to delete a course.
	 * 
	 * @param course the course to delete with id
	 */
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCourse(@RequestBody Course course) {
        courseRepository.delete(course);
    }
}
