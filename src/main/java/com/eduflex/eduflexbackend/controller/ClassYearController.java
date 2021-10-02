package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
import com.eduflex.eduflexbackend.service.ClassYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClassYearController {

    @Autowired
    ClassYearService classYearService;

    @Autowired
    ClassYearRepository classYearRepository;

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
}
