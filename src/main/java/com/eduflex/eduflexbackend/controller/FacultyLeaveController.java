package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.FacultyLeave;
import com.eduflex.eduflexbackend.repository.FacultyLeaveRepository;
import com.eduflex.eduflexbackend.service.FacultyLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyLeaveController {
    @Autowired
    FacultyLeaveService facultyLeaveService;

    @Autowired
    FacultyLeaveRepository facultyLeaveRepository;

    @GetMapping("/facultyLeaves")
    public List<FacultyLeave> getAllFacultyLeaves() {
        return facultyLeaveService.getAllFacultyLeaves();
    }

    @GetMapping("/faculty/{facultyId}/facultyLeaves")
    public List<FacultyLeave> getFacultyLeavesByFacultyId(@PathVariable int facultyId) {
        return facultyLeaveService.getFacultyLeavesByFacultyId(facultyId);
    }

    @GetMapping("/faculty/{facultyId}/facultyLeave/{facultyLeaveId}")
    public FacultyLeave getFacultyLeaveByFacultyLeaveId(@PathVariable int facultyId, @PathVariable int facultyLeaveId) {
        return facultyLeaveService.getFacultyLeaveByFacultyLeaveId(facultyId, facultyLeaveId);
    }

    @DeleteMapping("/faculty/{facultyId}/facultyLeave/{facultyLeaveId}")
    public void deleteFacultyLeave(@PathVariable int facultyId, @PathVariable int facultyLeaveId) {
        facultyLeaveService.deleteFacultyLeave(facultyId, facultyLeaveId);
    }

    @PutMapping("/faculty/{facultyId}/facultyLeave")
    FacultyLeave addFacultyLeaveToFaculty(@PathVariable int facultyId, @RequestBody FacultyLeave facultyLeave) {
        return facultyLeaveService.addFacultyLeaveToFaculty(facultyId, facultyLeave);
    }

    @GetMapping("/faculty/facultyLeaves/{facultyLeaveId}")
    public void deleteFacultyLeaveByFacultyLeaveID(@PathVariable int facultyLeaveId) {
        facultyLeaveService.deleteFacultyLeaveByFacultyLeaveID(facultyLeaveId);
    }
}