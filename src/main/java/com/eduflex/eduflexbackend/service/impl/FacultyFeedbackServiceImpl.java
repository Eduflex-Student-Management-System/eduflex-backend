package com.eduflex.eduflexbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyFeedback;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentFeedback;
import com.eduflex.eduflexbackend.repository.FacultyFeedbackRepository;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.service.FacultyFeedbackService;

@Service
public class FacultyFeedbackServiceImpl implements FacultyFeedbackService{
	
	@Autowired
	FacultyFeedbackRepository facultyFeedbackRepository;
	
	@Autowired
	FacultyRepository facultyRepository;

	@Override
	public FacultyFeedback addFacultyFeedbackToFaculty(int facultyId, FacultyFeedback facultyFeedback) {
		Faculty faculty = facultyRepository.findById(facultyId).get();
		facultyFeedback.setFaculty(faculty);
        	return facultyFeedbackRepository.save(facultyFeedback);
	}

	@Override
	public FacultyFeedback getFacultyFeedbackByFacultyFeedbackId(int facultyFeedbackId) {
        	return facultyFeedbackRepository.findById(facultyFeedbackId).get();
    	}

	@Override
	public List<FacultyFeedback> getFacultyFeedbacksByFacultyId(int facultyId) {
		Faculty faculty = facultyRepository.findById(facultyId).get();
	     	return facultyFeedbackRepository.findFacultyFeedbacksByFaculty(faculty);
	}

	@Override
	public List<FacultyFeedback> getAllFacultyFeedbacks() {
		return facultyFeedbackRepository.findAll();
	}

	@Override
	public void deleteFacultyFeedbackByFacultyId(int facultyId, int facultyFeedbackId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        List<FacultyFeedback> facultyFeedbackList = facultyFeedbackRepository.findFacultyFeedbacksByFaculty(faculty);
        	for (FacultyFeedback facultyFeedback : facultyFeedbackList) {
            		if (facultyFeedback.getFacultyFeedbackId() == facultyFeedbackId) {
                		facultyFeedbackRepository.deleteById(facultyFeedback.getFacultyFeedbackId());
            		} 
        	}
	}

	@Override
	public void deleteFacultyFeedbackByFacultyFeedbackId(int facultyFeedbackId) {
		 facultyFeedbackRepository.deleteById(facultyFeedbackId);
	}
}
