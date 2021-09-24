package com.eduflex.eduflexbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eduflex.eduflexbackend.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
