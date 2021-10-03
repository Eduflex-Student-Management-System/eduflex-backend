package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.CourseRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Student addCourseToStudent(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        student.setCourse(course);
        return studentRepository.save(student);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public Course getCourseByCourseName(String courseName) {
        return courseRepository.findCourseByCourseName(courseName);
    }
}