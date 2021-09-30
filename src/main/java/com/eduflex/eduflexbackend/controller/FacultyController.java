package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.service.FacultyService;

@CrossOrigin
@RestController
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;

	@Autowired
	FacultyRepository facultyRepository;
	
	@PostMapping("/faculty")
	public Faculty addFaculty(@RequestBody Faculty faculty) {
		if(StringUtils.isBlank(faculty.getFacultyName())) {
    		throw new EduflexDataNotFoundException("Faculty Name is required");
    	}
		return facultyService.addFaculty(faculty);
	}
	
	@PutMapping("/faculty")
	public Faculty updateFaculty(@RequestBody Faculty faculty) {
		return facultyService.updateFaculty(faculty);
	}
	
	@GetMapping("/faculties")
	public List<Faculty> getAllFaculties() {
		if(facultyRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Faculty Not Found, Add faculty first");
		}
		return facultyService.getAllFaculties();
	}

	@DeleteMapping("/faculty/{facultyId}")
	public void deleteFaculty(@PathVariable int facultyId) {
		if(!facultyRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't delete faculty, facultyId: "+facultyId+" not persent in database");
    	}
		facultyService.deleteFaculty(facultyId);
	}
	
	@GetMapping("/faculty/{facultyId}")
	public Faculty getFacultyById(@PathVariable int facultyId) {
		if(!facultyRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't find faculty with facultyId: "+facultyId+", please insert first");
    	}
		return facultyService.getFacultyByFacultyId(facultyId);
	}	
}
