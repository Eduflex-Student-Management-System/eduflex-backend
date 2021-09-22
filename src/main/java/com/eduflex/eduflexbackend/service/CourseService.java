package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Course;
import java.util.List;

public interface CourseService {
	Course addCourse(Course course);
	Course updateCourse(Course course);
	List<Course> getAllCourses();
	void deleteCourse(int courseId);
	Course getCourseById(int courseId);
}
