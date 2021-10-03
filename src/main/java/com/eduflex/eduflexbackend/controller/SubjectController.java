package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return subjectService.addSubject(subject);
    }

    @PutMapping("/subject")
    public Subject updateSubject(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @DeleteMapping("/subject/{subjectId}")
    public void deleteSubject(@PathVariable int subjectId) {
        subjectService.deleteSubjectBySubjectId(subjectId);
    }

    @GetMapping("/subject/{subjectId}")
    public Subject getSubjectById(@PathVariable int subjectId) {
        return subjectService.getSubjectBySubjectId(subjectId);
    }

    @PutMapping("/subject/{subjectId}/faculty/{facultyId}")
    Subject addSubjectToFaculty(@PathVariable int subjectId, @PathVariable int facultyId) {
        return subjectService.addSubjectToFaculty(subjectId, facultyId);
    }

    @GetMapping("/subjects/faculty/{facultyId}")
    public List<Subject> getAllSubjectsByFacultyId(@PathVariable int facultyId) {
        return subjectService.getAllSubjectsByFacultyId(facultyId);
    }

    @DeleteMapping("/subject/{subjectId}/faculty/{facultyId}")
    public void deleteSubjectByFacultyId(@PathVariable int subjectId, @PathVariable int facultyId) {
        subjectService.deleteSubjectByFacultyId(subjectId, facultyId);
    }
}
