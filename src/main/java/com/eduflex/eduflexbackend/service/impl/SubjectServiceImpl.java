package com.eduflex.eduflexbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
    
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
    
	@Override
	public Subject addSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject updateSubject(Subject subject) {	
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {	
		return subjectRepository.findAll();
	}

	@Override
	public void deleteSubjectBySubjectId(int subjectId) {
		subjectRepository.deleteById(subjectId);
	}

	@Override
	public Subject getSubjectBySubjectId(int subjectId) {
		return subjectRepository.findById(subjectId).get();
	}

	@Override
	public Subject addSubjectToFaculty(int subjectId, int facultyId) {
		Subject subject =subjectRepository.findById(subjectId).get();
		Faculty faculty =facultyRepository.findById(facultyId).get();
		subject.setFaculty(faculty);
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjectsByFacultyId(int facultyId) {
		Faculty faculty = facultyRepository.findById(facultyId).get();
		return subjectRepository.findSubjectsByFaculty(faculty);
	}

	@Override
	public void deleteSubjectByFacultyId(int subjectId,int facultyId) {
		Faculty faculty = facultyRepository.findById(facultyId).get();
		 List<Subject> subjectList = subjectRepository.findSubjectsByFaculty(faculty);
		 for(Subject subject:subjectList){
			 if(subject.getSubjectId()==subjectId)
				 	subjectRepository.deleteById(subjectId);
			 }
		}
}
