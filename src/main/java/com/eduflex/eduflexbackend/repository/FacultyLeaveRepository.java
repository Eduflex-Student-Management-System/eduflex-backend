package com.eduflex.eduflexbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyLeave;

@Repository
public interface FacultyLeaveRepository extends JpaRepository<FacultyLeave, Integer>{
	 List<FacultyLeave> findFacultyLeavesByFaculty(Faculty faculty);
}
