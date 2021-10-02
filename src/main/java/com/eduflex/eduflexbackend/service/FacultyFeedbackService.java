package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.FacultyFeedback;

import java.util.List;

public interface FacultyFeedbackService {
    FacultyFeedback addFacultyFeedbackToFaculty(int facultyId, FacultyFeedback facultyFeedback);

    FacultyFeedback getFacultyFeedbackByFacultyFeedbackId(int facultyFeedbackId);

    List<FacultyFeedback> getFacultyFeedbacksByFacultyId(int facultyId);

    List<FacultyFeedback> getAllFacultyFeedbacks();

    void deleteFacultyFeedbackByFacultyId(int facultyId, int facultyFeedbackId);

    void deleteFacultyFeedbackByFacultyFeedbackId(int facultyFeedbackId);
}
