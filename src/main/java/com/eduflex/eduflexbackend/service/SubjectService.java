package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject Subject);

    Subject updateSubject(Subject subject);

    Subject getSubjectBySubjectId(int subjectId);

    Subject addSubjectToFaculty(int subjectId, int facultyId);

    List<Subject> getAllSubjects();

    List<Subject> getAllSubjectsByFacultyId(int facultyId);

    void deleteSubjectBySubjectId(int subjectId);

    void deleteSubjectByFacultyId(int subjectId, int facultyId);
}


