package com.ebit.dot.company.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.dot.company.entity.Course;
import com.ebit.dot.company.service.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}
	@GetMapping("/courses/{id}")
    public Optional<Course> getByCourse(@PathVariable int id) {
		return courseService.getByCourse(id);
	}
	@PostMapping("/courses")
	public void addCourse(@RequestBody @Valid Course course) {
		courseService.addCourse(course);
	}
	@PutMapping("/courses/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable int id) {
		return courseService.updateCourse(course, id);
	}
	@DeleteMapping("/courses/{id}") 
	public void	deleteById(@PathVariable int id) { 
		courseService.deleteById(id);
	}
	@DeleteMapping("/courses")
	public void deleteAllCourse(@RequestBody Course course) {
		courseService.deleteAllCourse(course);
	}
//	@GetMapping("/courses/{name}")
//	public Optional<Course> getByName(@PathVariable String name) {
//		return courseService.getByName(name);
//	}
//	

	
}