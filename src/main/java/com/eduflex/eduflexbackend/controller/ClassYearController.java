package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.service.ClassYearService;
import com.eduflex.eduflexbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClassYearController {
    @Autowired
    ClassYearService classYearService;

    @PostMapping("/classYear")
    public ClassYear addClassYear(@RequestBody ClassYear classYear) {
        return classYearService.addClassYear(classYear);
    }
    @GetMapping("/classYear/{classYearId}")
    public ClassYear getClassYearById(@PathVariable int classYearId) {
        return classYearService.getClassYearById(classYearId);
    }
    @DeleteMapping("/classYear/{classYearId}")
    public void deleteClassYearById(@PathVariable int classYearId) {
        classYearService.deleteClassYearById(classYearId);
    }
    @GetMapping("/classYears")
    public List<ClassYear> getAllClassYears() {
        return classYearService.getAllClassYears();
    }
    @PutMapping("/student/{studentId}/classYear/{classYearId}")
    public ClassYear addClassYearToStudent(@PathVariable int studentId, @PathVariable int classYearId){
        return classYearService.addClassYearToStudent(studentId,classYearId);
    }

}
