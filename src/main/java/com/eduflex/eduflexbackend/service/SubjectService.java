package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.Subject;

public interface SubjectService {
		Subject addSubject(Subject Subject);
    	Subject updateSubject(Subject subject);
    	Subject getSubjectBySubjectId(int subjectId);
    	Subject addSubjectToFaculty(int subjectId,int facultyId);
		List<Subject> getAllSubjects();
    	List<Subject> getAllSubjectsByFacultyId(int facultyId);
		void deleteSubjectBySubjectId(int subjectId);
    	void deleteSubjectByFacultyId(int subjectId,int facultyId);
}


