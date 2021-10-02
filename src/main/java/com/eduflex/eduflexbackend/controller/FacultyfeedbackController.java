package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.FacultyFeedback;
import com.eduflex.eduflexbackend.repository.FacultyFeedbackRepository;
import com.eduflex.eduflexbackend.service.FacultyFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyfeedbackController {

    @Autowired
    FacultyFeedbackService facultyFeedbackService;

    @Autowired
    FacultyFeedbackRepository facultyFeedbackRepository;

    @PutMapping("/faculty/{facultyId}/facultyFeedback")
    public FacultyFeedback addFacultyFeedbackToStudent(@PathVariable int facultyId, @RequestBody FacultyFeedback facultyFeedback) {
        return facultyFeedbackService.addFacultyFeedbackToFaculty(facultyId, facultyFeedback);
    }

    @GetMapping("/faculty/facultyFeedback/{facultyFeedbackId}")
    public FacultyFeedback getFacultyFeedbackByFacultyFeedbackId(@PathVariable int facultyFeedbackId) {
        return facultyFeedbackService.getFacultyFeedbackByFacultyFeedbackId(facultyFeedbackId);
    }

    @GetMapping("/faculty/{facultyId}/facultyFeedbacks")
    public List<FacultyFeedback> getFacultyFeedbacksByFacultyId(@PathVariable int facultyId) {
        return facultyFeedbackService.getFacultyFeedbacksByFacultyId(facultyId);
    }

    @GetMapping("/facultyFeedbacks")
    public List<FacultyFeedback> getAllFacultyFeedbacks() {
        return facultyFeedbackService.getAllFacultyFeedbacks();
    }

    @DeleteMapping("/faculty/{facultyId}/facultyFeedback/{facultyFeedbackId}")
    public void deleteFacultyFeedbackByFacultyId(@PathVariable int facultyId, @PathVariable int facultyFeedbackId) {
        facultyFeedbackService.deleteFacultyFeedbackByFacultyId(facultyId, facultyFeedbackId);
    }

    @DeleteMapping("/faculty/facultyFeedback/{facultyFeedbackId}")
    public void deleteFacultyFeedbackByFacultyFeedbackId(@PathVariable int facultyFeedbackId) {
        facultyFeedbackService.deleteFacultyFeedbackByFacultyFeedbackId(facultyFeedbackId);
    }
}
