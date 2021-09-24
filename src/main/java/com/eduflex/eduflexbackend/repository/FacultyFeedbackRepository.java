package com.eduflex.eduflexbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyFeedback;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentFeedback;


public interface FacultyFeedbackRepository extends JpaRepository<FacultyFeedback, Integer> {
   List<FacultyFeedback> findFacultyFeedbacksByFaculty(Faculty faculty);
}
