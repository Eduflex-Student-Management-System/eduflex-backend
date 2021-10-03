package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/faculty/{facultyId}")
    public Faculty getFacultyById(@PathVariable int facultyId) {
        return facultyService.getFacultyByFacultyId(facultyId);
    }

    @GetMapping("/faculty/{facultyUsername}/{facultyPassword}")
    public Faculty getFacultyByFacultyUsernameAndAndFacultyPassword(@PathVariable String facultyUsername, @PathVariable String facultyPassword) {
        return facultyService.getFacultyByFacultyUsernameAndAndFacultyPassword(facultyUsername, facultyPassword);
    }
}