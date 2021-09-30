package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.FacultyLeave;
import com.eduflex.eduflexbackend.repository.FacultyLeaveRepository;
import com.eduflex.eduflexbackend.service.FacultyLeaveService;

@CrossOrigin
@RestController
public class FacultyLeaveController {
	@Autowired
	FacultyLeaveService facultyLeaveService;
	
	@Autowired
	FacultyLeaveRepository facultyLeaveRepository;

	@GetMapping("/facultyLeaves")
	public List<FacultyLeave> getAllFacultyLeaves() {
		if(facultyLeaveRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("FacultyLeave Not Found, Add facultyLeave first");
		}
		return facultyLeaveService.getAllFacultyLeaves();
	}
	
    @GetMapping("/faculty/{facultyId}/facultyLeaves")
    public List<FacultyLeave> getFacultyLeavesByFacultyId(@PathVariable int facultyId) {
    	if(facultyLeaveRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("facultyLeave with facultyId "+facultyId+" Not Found, Add facultyLeave first");
		}
        return facultyLeaveService.getFacultyLeavesByFacultyId(facultyId);
    }
	
    @GetMapping("/faculty/{facultyId}/facultyLeave/{facultyLeaveId}")
	public FacultyLeave getFacultyLeaveByFacultyLeaveId(@PathVariable int facultyId,@PathVariable int facultyLeaveId) {
    	if(!facultyLeaveRepository.existsById(facultyLeaveId)) {
    		throw new EduflexDataNotFoundException("Can't find facultyLeave with facultyLeaveId: "+facultyLeaveId+", please insert first");
    	}
        return facultyLeaveService.getFacultyLeaveByFacultyLeaveId(facultyId, facultyLeaveId);
    }
	
	@DeleteMapping("/faculty/{facultyId}/facultyLeave/{facultyLeaveId}")
	public void deleteFacultyLeave(@PathVariable int facultyId,@PathVariable int facultyLeaveId) {
		if(!facultyLeaveRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't delete facultyLeave, facultyId: "+facultyId+", not have FacultyLeave in database");
    	}
		facultyLeaveService.deleteFacultyLeave(facultyId,facultyLeaveId);
	}
	
	@PutMapping("/faculty/{facultyId}/facultyLeave")
	FacultyLeave addFacultyLeaveToFaculty(@PathVariable int facultyId,@RequestBody  FacultyLeave facultyLeave) {
		if(!facultyLeaveRepository.existsById(facultyId)) {
    		throw new EduflexDataNotFoundException("Can't add studentLeave to facultyId: "+facultyId+", because it not persent in database");
    	}
		  return facultyLeaveService.addFacultyLeaveToFaculty(facultyId, facultyLeave);}
	
	@GetMapping("/faculty/facultyLeaves/{facultyLeaveId}")
	public void deleteFacultyLeaveByFacultyLeaveID(@PathVariable int facultyLeaveId) {
		if(!facultyLeaveRepository.existsById(facultyLeaveId)) {
    		throw new EduflexDataNotFoundException("Can't find facultyLeave with facultyLeaveId: "+facultyLeaveId+", please insert first");
    	}
		facultyLeaveService.deleteFacultyLeaveByFacultyLeaveID(facultyLeaveId);
		}
}