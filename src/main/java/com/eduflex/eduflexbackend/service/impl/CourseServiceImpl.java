package com.eduflex.eduflexbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.repository.CourseRepository;
import com.eduflex.eduflexbackend.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public Course getCourseById(int courseId) {
		return courseRepository.findById(courseId).get();
	}

	
}
