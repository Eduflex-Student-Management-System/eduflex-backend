package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.Subject;

public interface SubjectService {
	Subject addSubject(Subject Subject);
    Subject updateSubject(Subject subject);
    List<Subject> getAllSubjects();
    void deleteSubjectBySubjectId(int subjectId);
    Subject getSubjectBySubjectId(int subjectId);
    
    Subject addSubjectToFaculty(int subjectId,int facultyId);
    List<Subject> getAllSubjectsByFacultyId(int facultyId);
    void deleteSubjectByFacultyId(int subjectId,int facultyId);
    
    
}


