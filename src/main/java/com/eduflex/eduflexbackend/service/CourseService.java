package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.model.Student;

import java.util.List;

public interface CourseService {
	Course addCourse(Course course);
	Student addCourseToStudent(int studentId, int courseId);
	List<Course> getAllCourses();
	Course getCourseByCourseId(int courseId);
	Course getCourseByCourseName(String courseName);
}