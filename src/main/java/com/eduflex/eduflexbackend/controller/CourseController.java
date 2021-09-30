package com.eduflex.eduflexbackend.controller;

import java.util.List;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.CourseRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.service.CourseService;

@CrossOrigin
@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		if(StringUtils.isBlank(course.getCourseName())) {
    		throw new EduflexDataNotFoundException("Course Name is required");
    	}
		return courseService.addCourse(course);
	}

	@PutMapping("/student/{studentId}/course/{courseId}")
	public Student addCourseToStudent(@PathVariable int studentId, @PathVariable int courseId) {
		if(!studentRepository.existsById(studentId) && !courseRepository.existsById(courseId)) {
    		throw new EduflexDataNotFoundException("courseId: "+courseId+" can't be inserted to studentId "+studentId);
    	}
		return courseService.addCourseToStudent(studentId, courseId);
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		if(courseRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Course Not Found, Add Course first");
		}
		return courseService.getAllCourses();
	}

	@GetMapping("/course/{courseId}")
	public Course getCourseByCourseId(@PathVariable int courseId) {
		if(!courseRepository.existsById(courseId)) {
    		throw new EduflexDataNotFoundException("Can't find course with courseId: "+courseId+", please insert first");
    	}
		return courseService.getCourseByCourseId(courseId);
	}
}
