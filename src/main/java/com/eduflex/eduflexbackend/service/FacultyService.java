package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.Faculty;

public interface FacultyService {
	Faculty addFaculty(Faculty faculty);
	Faculty updateFaculty(Faculty faculty);
	List<Faculty> getAllFaculties();
	void deleteFaculty(int facultyId);
	Faculty getFacultyByFacultyId(int facultyLeaveId);
}
	
