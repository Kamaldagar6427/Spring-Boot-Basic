package com.ebit.dot.company.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ebit.dot.company.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findCourseById(int id);

	



	
}
