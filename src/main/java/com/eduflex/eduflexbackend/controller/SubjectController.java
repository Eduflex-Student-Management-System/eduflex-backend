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
import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.SubjectService;

@CrossOrigin
@RestController
public class SubjectController {
   
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	SubjectRepository subjectRepository; 
	
	@Autowired
	FacultyRepository facultyRepository;

	@PostMapping("/subject")
	public Subject addSubject(@RequestBody Subject subject) {
		if(StringUtils.isBlank(subject.getSubjectName())) {
    		throw new EduflexDataNotFoundException("Subject Name is required");
    	}
		return subjectService.addSubject(subject)  ;
	}

	@PutMapping("/subject")
	public Subject updateSubject(@RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}

	@GetMapping("/subjects")
	public List<Subject> getAllSubjects() {
		if(subjectRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Subject Not Found, Add subject first");
		}
		return subjectService.getAllSubjects();
	}

	@DeleteMapping("/subject/{subjectId}")
	public void deleteSubject(@PathVariable int subjectId) {
		if(!subjectRepository.existsById(subjectId)) {
    		throw new EduflexDataNotFoundException("Can't delete subject, subjectId: "+subjectId+" not persent in database");
    	}
		subjectService.deleteSubjectBySubjectId(subjectId);
	}

	@GetMapping("/subject/{subjectId}")
	public Subject getSubjectById(@PathVariable int subjectId) {
		if(!subjectRepository.existsById(subjectId)) {
    		throw new EduflexDataNotFoundException("Can't find student with subjectId: "+subjectId+", please insert first");
    	}
		return subjectService.getSubjectBySubjectId(subjectId);
	}
	
	@PutMapping("/subject/{subjectId}/faculty/{facultyId}")
	Subject addSubjectToFaculty(@PathVariable int subjectId,@PathVariable int facultyId) {
		if(!subjectRepository.existsById(subjectId) && !facultyRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("subjectId  "+subjectId+" can't be inserted to facultyId "+facultyId);
    	}
		return subjectService.addSubjectToFaculty(subjectId, facultyId);
	}
	
	@GetMapping("/subjects/faculty/{facultyId}")
	public List<Subject> getAllSubjectsByFacultyId(@PathVariable int facultyId){
		if(subjectRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Subject with facultyId "+facultyId+" Not Found, Add subject first");
		}
		return subjectService.getAllSubjectsByFacultyId(facultyId);
	}
	
	@DeleteMapping("/subject/{subjectId}/faculty/{facultyId}")
	public void deleteSubjectByFacultyId(@PathVariable int subjectId,@PathVariable int facultyId){
		if(!subjectRepository.existsById(subjectId) && !facultyRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Subject with "+subjectId+"can't be deleted, because faculty with facultyId "+facultyId+" not persent in database");
    	}
		 subjectService.deleteSubjectByFacultyId(subjectId,facultyId);
	}
}
