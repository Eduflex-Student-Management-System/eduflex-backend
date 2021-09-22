package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.Subject;

public interface SubjectService {
	Subject addSubject(Subject Subject);
    Subject updateSubject(Subject subject);
    List<Subject> getAllSubjects();
    void deleteSubject(int subjectId);
    Subject getSubjectById(int subjectId);
}


