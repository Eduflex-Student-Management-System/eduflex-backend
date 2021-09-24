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

import com.eduflex.eduflexbackend.model.FacultyLeave;
import com.eduflex.eduflexbackend.service.FacultyLeaveService;

@CrossOrigin
@RestController
public class FacultyLeaveController {
	@Autowired
	FacultyLeaveService facultyLeaveService;

	@GetMapping("/facultyLeaves")
	public List<FacultyLeave> getAllFacultyLeaves() {
		return facultyLeaveService.getAllFacultyLeaves();
	}
	//newAdded
    @GetMapping("/faculty/{facultyId}/facultyLeaves")
    public List<FacultyLeave> getFacultyLeavesByFacultyId(@PathVariable int facultyId) {
        return facultyLeaveService.getFacultyLeavesByFacultyId(facultyId);
    }
	
    @GetMapping("/faculty/{facultyId}/facultyLeave/{facultyLeaveId}")
	public FacultyLeave getFacultyLeaveByFacultyLeaveId(@PathVariable int facultyId,@PathVariable int facultyLeaveId) {
        return facultyLeaveService.getFacultyLeaveByFacultyLeaveId(facultyId, facultyLeaveId);
    }
	
	@DeleteMapping("/faculty/{facultyId}/facultyLeave/{facultyLeaveId}")
	public void deleteFacultyLeave(@PathVariable int facultyId,@PathVariable int facultyLeaveId) {
		facultyLeaveService.deleteFacultyLeave(facultyId,facultyLeaveId);
	}
	
	@PutMapping("/faculty/{facultyId}/facultyLeave")
	FacultyLeave addFacultyLeaveToFaculty(@PathVariable int facultyId,@RequestBody  FacultyLeave facultyLeave) {
		  return facultyLeaveService.addFacultyLeaveToFaculty(facultyId, facultyLeave);}
	
	@GetMapping("/faculty/facultyLeaves/{facultyLeaveId}")
	public void deleteFacultyLeaveByFacultyLeaveID(@PathVariable int facultyLeaveId)
	{ facultyLeaveService.deleteFacultyLeaveByFacultyLeaveID(facultyLeaveId);}
}