package com.eduflex.eduflexbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
    
	@Autowired
	SubjectRepository subjectRepository;
    
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
	public void deleteSubject(int subjectId) {
		subjectRepository.deleteById(subjectId);
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		return subjectRepository.findById(subjectId).get();
	}

	
 	

}
