package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.CourseRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return courseService.addCourse(course);
    }

    @PutMapping("/student/{studentId}/course/{courseId}")
    public Student addCourseToStudent(@PathVariable int studentId, @PathVariable int courseId) {
        return courseService.addCourseToStudent(studentId, courseId);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseId}")
    public Course getCourseByCourseId(@PathVariable int courseId) {
        return courseService.getCourseByCourseId(courseId);
    }

    @GetMapping("/course/courseName/{courseName}")
    public Course getCourseByCourseName(@PathVariable String courseName) {
        return courseService.getCourseByCourseName(courseName);
    }
}
