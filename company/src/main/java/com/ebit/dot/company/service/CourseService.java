package com.ebit.dot.company.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebit.dot.company.entity.Course;
import com.ebit.dot.company.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> course = new ArrayList<>(Arrays.asList(
//			new Course("1", "Kamlesh", "Jaipur"),
//			new Course("2", "Ankit", "Sikar"),
//			new Course("3", "Sonu", "Alwar"),
//			new Course("4", "Ajay", "Sikar")));
//
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public Optional<Course> getByCourse(int id) {	
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		 courseRepository.save(course);
	}
	
	public Course updateCourse(Course course, int id) {
		Course c = courseRepository.findCourseById(id);
		if (c != null) {
			c.setName(course.getName());
			c.setAddress(course.getAddress());
			return courseRepository.save(c);
		}
		return null;
	}
	

	public void deleteById(int id) {
		courseRepository.deleteById(id);
	}

	public void deleteAllCourse(Course course) {
		courseRepository.deleteAll();
		
	}

	

//	public Optional<Course> getByName(String name) {
//		return courseRepository.findByName(name);
//		
//	}

	
}