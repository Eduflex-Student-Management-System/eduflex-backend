package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.StudentFeedback;
import com.eduflex.eduflexbackend.repository.StudentFeedbackRepository;
import com.eduflex.eduflexbackend.service.StudentFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentFeedbackController {

    @Autowired
    StudentFeedbackService studentFeedbackService;

    @Autowired
    StudentFeedbackRepository studentFeedbackRepository;

    @PutMapping("/student/{studentId}/studentFeedback")
    public StudentFeedback addStudentFeedbackToStudent(@PathVariable int studentId, @RequestBody StudentFeedback studentFeedback) {
        return studentFeedbackService.addStudentFeedbackToStudent(studentId, studentFeedback);
    }

    @GetMapping("/student/studentFeedback/{studentFeedbackId}")
    public StudentFeedback getStudentFeedbackByStudentFeedbackId(@PathVariable int studentFeedbackId) {
        return studentFeedbackService.getStudentFeedbackByStudentFeedbackId(studentFeedbackId);
    }

    @GetMapping("/student/{studentId}/studentFeedbacks")
    public List<StudentFeedback> getStudentFeedbacksByStudentId(@PathVariable int studentId) {
        return studentFeedbackService.getStudentFeedbacksByStudentId(studentId);
    }

    @GetMapping("/studentFeedbacks")
    public List<StudentFeedback> getAllStudentFeedbacks() {
        return studentFeedbackService.getAllStudentFeedbacks();
    }

    @DeleteMapping("/student/{studentId}/studentFeedback/{studentFeedbackId}")
    public void deleteStudentFeedbackByStudentId(@PathVariable int studentId, @PathVariable int studentFeedbackId) {
        studentFeedbackService.deleteStudentFeedbackByStudentId(studentId, studentFeedbackId);
    }

    @DeleteMapping("/student/studentFeedback/{studentFeedbackId}")
    public void deleteStudentFeedbackByStudentFeedbackId(@PathVariable int studentFeedbackId) {
        studentFeedbackService.deleteStudentFeedbackByStudentFeedbackId(studentFeedbackId);
    }
}
