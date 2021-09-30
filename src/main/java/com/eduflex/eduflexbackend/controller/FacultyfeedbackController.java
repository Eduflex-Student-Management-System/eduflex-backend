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

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.FacultyFeedback;
import com.eduflex.eduflexbackend.repository.FacultyFeedbackRepository;
import com.eduflex.eduflexbackend.service.FacultyFeedbackService;

@CrossOrigin
@RestController
public class FacultyfeedbackController  {
	
    @Autowired
    FacultyFeedbackService facultyFeedbackService;
    
    @Autowired
    FacultyFeedbackRepository facultyFeedbackRepository;

    @PutMapping("/faculty/{facultyId}/facultyFeedback")
    public FacultyFeedback addFacultyFeedbackToStudent(@PathVariable int facultyId, @RequestBody FacultyFeedback facultyFeedback) {
    	if(!facultyFeedbackRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't add facultyFeedback to facultyId: "+facultyId+", because it not persent in database");
    	}
        return facultyFeedbackService.addFacultyFeedbackToFaculty(facultyId,facultyFeedback);
    }

    @GetMapping("/faculty/facultyFeedback/{facultyFeedbackId}")
    public FacultyFeedback getFacultyFeedbackByFacultyFeedbackId(@PathVariable int facultyFeedbackId) {
    	if(!facultyFeedbackRepository.existsById(facultyFeedbackId)) {
    		throw new EduflexDataNotFoundException("Can't find facultyFeedback with facultyFeedbackId: "+facultyFeedbackId+", please insert first");
    	}
        return facultyFeedbackService.getFacultyFeedbackByFacultyFeedbackId(facultyFeedbackId);
    }

    @GetMapping("/faculty/{facultyId}/facultyFeedbacks")
    public List<FacultyFeedback> getFacultyFeedbacksByFacultyId(@PathVariable int facultyId) {
    	if(!facultyFeedbackRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't find facultyFeedback with facultyId: "+facultyId+", please insert first");
    	}
        return facultyFeedbackService.getFacultyFeedbacksByFacultyId(facultyId);
    }

    @GetMapping("/facultyFeedbacks")
    public List<FacultyFeedback> getAllFacultyFeedbacks() {
    	if(facultyFeedbackRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("FacultyFeedback Not Found, Add facultyFeedbacks first");
		}
        return facultyFeedbackService.getAllFacultyFeedbacks();
    }

    @DeleteMapping("/faculty/{facultyId}/facultyFeedback/{facultyFeedbackId}")
    public void deleteFacultyFeedbackByFacultyId(@PathVariable int facultyId, @PathVariable int facultyFeedbackId) {
    	if(!facultyFeedbackRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't delete facultyFeedback, facultyId: "+facultyId+", not have facultyFeedback in database");
    	}
    	facultyFeedbackService.deleteFacultyFeedbackByFacultyId(facultyId, facultyFeedbackId);
    }

    @DeleteMapping("/faculty/facultyFeedback/{facultyFeedbackId}")
    public void deleteFacultyFeedbackByFacultyFeedbackId( @PathVariable int facultyFeedbackId) {
    	if(!facultyFeedbackRepository.existsById(facultyFeedbackId)) {
    		throw new EduflexDataNotFoundException("Can't delete facultyFeedback, facultyFeedbackId: "+facultyFeedbackId+", not persent in database");
    	}
    	facultyFeedbackService.deleteFacultyFeedbackByFacultyFeedbackId(facultyFeedbackId);
    }
}
