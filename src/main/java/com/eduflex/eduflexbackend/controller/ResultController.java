package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Result;
import com.eduflex.eduflexbackend.repository.ResultRepository;
import com.eduflex.eduflexbackend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ResultController {

    @Autowired
    ResultService resultService;
    
    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/student/result/{resultId}")
    public Result getResultByResultId(@PathVariable int resultId) {
    	if(!resultRepository.existsById(resultId)) {
    		throw new EduflexDataNotFoundException("Can't find result with resultId: "+resultId+", please insert first");
    	}
        return resultService.getResultByResultId(resultId);
    }

    @PutMapping("/student/{studentId}/result")
    public Result addResultToStudent(@RequestBody Result result, @PathVariable int studentId) {
    	if(!resultRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't add result to studentId: "+studentId+", because it not persent in database");
    	}
        return resultService.addResultToStudent(result, studentId);
    }

    @GetMapping("/student/{studentId}/result")
    public Result getResultByStudentId(@PathVariable int studentId) {
    	if(!resultRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't find result with resultId: "+studentId+", please insert first");
    	}
        return resultService.getResultByStudentId(studentId);
    }

    @DeleteMapping("/student/result/{resultId}")
    public void deleteResultByResultId(@PathVariable int resultId) {
    	if(!resultRepository.existsById(resultId)) {
    		throw new EduflexDataNotFoundException("Can't delete result, resultId: "+resultId+" not persent in database");
    	}
        resultService.deleteResultByResultId(resultId);
    }

    @GetMapping("/results")
    public List<Result> getAllResults() {
    	if(resultRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Result Not Found, Add result first");
		}
        return resultService.getAllResults();
    }
}
