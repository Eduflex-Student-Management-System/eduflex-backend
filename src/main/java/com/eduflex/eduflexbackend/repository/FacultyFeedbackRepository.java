package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyFeedbackRepository extends JpaRepository<FacultyFeedback, Integer> {
    List<FacultyFeedback> findFacultyFeedbacksByFaculty(Faculty faculty);
}
