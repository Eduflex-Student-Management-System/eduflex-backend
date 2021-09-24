package com.eduflex.eduflexbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	FacultyRepository facultyRepository;
	
	@Override
	public Faculty addFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public List<Faculty> getAllFaculties() {
		return facultyRepository.findAll();
	}

	@Override
	public void deleteFaculty(int facultyId) {
		facultyRepository.deleteById(facultyId);
	}

//	@Override
//	public List<Faculty> getSubjectByFacultyId(int facultyId) {
//		// remainning work
//		return facultyRepository.findAllSubjectByFacultyId(facultyId);
//	}

	@Override
	public Faculty getFacultyByFacultyId(int facultyId) {
		return facultyRepository.findById(facultyId).get();
	}
}
