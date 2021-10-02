package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);

    Faculty updateFaculty(Faculty faculty);

    List<Faculty> getAllFaculties();

    void deleteFaculty(int facultyId);

    Faculty getFacultyByFacultyId(int facultyLeaveId);

    Faculty getFacultyByFacultyUsernameAndAndFacultyPassword(String facultyUsername, String facultyPassword);

}
	
