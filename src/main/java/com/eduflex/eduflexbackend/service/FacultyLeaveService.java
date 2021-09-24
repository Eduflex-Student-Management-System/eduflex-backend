package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.FacultyLeave;

public interface FacultyLeaveService {
	List<FacultyLeave> getAllFacultyLeaves();
	void deleteFacultyLeave(int facultyId,int facultyLeaveId);
	List<FacultyLeave> getFacultyLeavesByFacultyId(int facultyId);
    	FacultyLeave getFacultyLeaveByFacultyLeaveId(int facultyId ,int facultyLeaveId);
	FacultyLeave addFacultyLeaveToFaculty(int facultyId, FacultyLeave facultyLeave);
    	void deleteFacultyLeaveByFacultyLeaveID(int facultyId);
}
