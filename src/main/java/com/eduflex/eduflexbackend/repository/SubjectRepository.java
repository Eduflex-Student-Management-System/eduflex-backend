package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findSubjectsByFaculty(Faculty faculty);
}
