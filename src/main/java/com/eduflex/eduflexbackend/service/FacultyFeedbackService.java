package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.FacultyFeedback;


public interface FacultyFeedbackService {

	FacultyFeedback addFacultyFeedbackToFaculty(int facultyId, FacultyFeedback facultyFeedback);
	FacultyFeedback getFacultyFeedbackByFacultyFeedbackId(int facultyFeedbackId);
	List<FacultyFeedback> getFacultyFeedbacksByFacultyId(int facultyId);
	List<FacultyFeedback> getAllFacultyFeedbacks();
	void deleteFacultyFeedbackByFacultyId(int facultyId, int facultyFeedbackId);
	void deleteFacultyFeedbackByFacultyFeedbackId(int facultyFeedbackId);
}
