package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.FacultyLeave;

import java.util.List;

public interface FacultyLeaveService {
    List<FacultyLeave> getAllFacultyLeaves();

    void deleteFacultyLeave(int facultyId, int facultyLeaveId);

    List<FacultyLeave> getFacultyLeavesByFacultyId(int facultyId);

    FacultyLeave getFacultyLeaveByFacultyLeaveId(int facultyId, int facultyLeaveId);

    FacultyLeave addFacultyLeaveToFaculty(int facultyId, FacultyLeave facultyLeave);

    void deleteFacultyLeaveByFacultyLeaveID(int facultyId);
}
