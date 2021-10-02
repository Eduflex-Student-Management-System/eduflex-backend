package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyLeaveRepository extends JpaRepository<FacultyLeave, Integer> {
    List<FacultyLeave> findFacultyLeavesByFaculty(Faculty faculty);
}
