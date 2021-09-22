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

import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.service.SubjectService;

@CrossOrigin
@RestController
public class SubjectController {
   
	@Autowired
	SubjectService subjectService;

	@PostMapping("/subject")
	public Subject addSubject(@RequestBody Subject subject) {
		// TODO Auto-generated method stub
		return subjectService.addSubject(subject)  ;
	}

	@PutMapping("/subject")
	public Subject updateSubject(@RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}

	@GetMapping("/subjects")
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectService.getAllSubjects();
	}

	@DeleteMapping("/subject/{subjectId}")
	public void deleteSubject(@PathVariable int subjectId) {
		subjectService.deleteSubject(subjectId);
		
	}

	@GetMapping("/subject/{subjectId}")
	public Subject getSubjectById(@PathVariable int subjectId) {
		// TODO Auto-generated method stub
		return subjectService.getSubjectById(subjectId);
	}

}
