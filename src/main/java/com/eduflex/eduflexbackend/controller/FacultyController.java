package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.service.FacultyService;

@CrossOrigin
@RestController
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;

	@PostMapping("/faculty")
	public Faculty addFaculty(@RequestBody Faculty faculty) {
		return facultyService.addFaculty(faculty);
	}
	
	@PutMapping("/faculty")
	public Faculty updateFaculty(@RequestBody Faculty faculty) {
		return facultyService.updateFaculty(faculty);
	}
	
	@GetMapping("/faculties")
	public List<Faculty> getAllFaculties() {
		return facultyService.getAllFaculties();
	}

	@DeleteMapping("/faculty/{facultyId}")
	public void deleteFaculty(@PathVariable int facultyId) {
		facultyService.deleteFaculty(facultyId);
	}
//	
//	@GetMapping("/subjects/faculty/{facultyId}")
//	public List<Faculty> getSubjectByFacultyId(@PathVariable int facultyId) {
//		return facultyService.getSubjectByFacultyId(facultyId);
//	}
	
	@GetMapping("/faculty/{facultyId}")
	public Faculty getFacultyById(@PathVariable int facultyId) {
		return facultyService.getFacultyByFacultyId(facultyId);
	}

	
}
