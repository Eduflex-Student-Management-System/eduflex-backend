package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseByCourseName(String courseName);
}