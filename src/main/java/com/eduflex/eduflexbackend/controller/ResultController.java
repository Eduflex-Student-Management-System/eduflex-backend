package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Result;
import com.eduflex.eduflexbackend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ResultController {

    @Autowired
    ResultService resultService;

    @GetMapping("/student/result/{resultId}")
    public Result getResultByResultId(@PathVariable int resultId) {
        return resultService.getResultByResultId(resultId);
    }

    @PutMapping("/student/{studentId}/result")
    public Result addResultToStudent(@RequestBody Result result, @PathVariable int studentId) {
        return resultService.addResultToStudent(result, studentId);
    }

    @GetMapping("/student/{studentId}/result")
    public Result getResultByStudentId(@PathVariable int studentId) {
        return resultService.getResultByStudentId(studentId);
    }

    @DeleteMapping("/student/result/{resultId}")
    public void deleteResultByResultId(@PathVariable int resultId) {
        resultService.deleteResultByResultId(resultId);
    }

    @GetMapping("/results")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }
}
