package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.service.CourseService;

@CrossOrigin
@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@DeleteMapping("/course/{courseId}")
	public void deleteCourse(@PathVariable int courseId) {
		courseService.deleteCourse(courseId);
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourseById(@PathVariable int courseId) {
		return courseService.getCourseById(courseId);
	}
	
	
}
