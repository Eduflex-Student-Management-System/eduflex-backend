package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFeedbackRepository extends JpaRepository<StudentFeedback, Integer> {
    List<StudentFeedback> findStudentFeedbacksByStudent(Student student);
}
