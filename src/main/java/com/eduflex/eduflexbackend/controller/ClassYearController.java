package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
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
    
    @Autowired
    ClassYearRepository classYearRepository;

    @PostMapping("/classYear")
    public ClassYear addClassYear(@RequestBody ClassYear classYear) {
    	if(!classYearRepository.equals(classYear)) {
    		throw new EduflexDataNotFoundException("ClassYearStartDate is required");
    	}
        return classYearService.addClassYear(classYear);
    }
    
    @GetMapping("/classYear/{classYearId}")
    public ClassYear getClassYearById(@PathVariable int classYearId) {
    	if(classYearRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("ClassYear with classYearId "+classYearId+" Not Found, Add classYear first");
		}
        return classYearService.getClassYearById(classYearId);
    }
    
    @DeleteMapping("/classYear/{classYearId}")
    public void deleteClassYearById(@PathVariable int classYearId) {
    	if(!classYearRepository.existsById(classYearId)) {
    		throw new EduflexDataNotFoundException("Can't delete classYear, classYearId: "+classYearId+" not persent in database");
    	}
        classYearService.deleteClassYearById(classYearId);
    }
    
    @GetMapping("/classYears")
    public List<ClassYear> getAllClassYears() {
    	if(classYearRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("classYear Not Found, Add classYear first");
		}
        return classYearService.getAllClassYears();
    }
}
