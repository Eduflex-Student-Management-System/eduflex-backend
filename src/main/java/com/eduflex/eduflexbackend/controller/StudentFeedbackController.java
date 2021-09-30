package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.StudentFeedback;
import com.eduflex.eduflexbackend.repository.StudentFeedbackRepository;
import com.eduflex.eduflexbackend.service.StudentFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentFeedbackController {

    @Autowired
    StudentFeedbackService studentFeedbackService;
    
    @Autowired
    StudentFeedbackRepository studentFeedbackRepository;

    @PutMapping("/student/{studentId}/studentFeedback")
    public StudentFeedback addStudentFeedbackToStudent(@PathVariable int studentId, @RequestBody StudentFeedback studentFeedback) {
    	if(!studentFeedbackRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't add studentFeedback to studentId: "+studentId+", because it not persent in database");
    	}
        return studentFeedbackService.addStudentFeedbackToStudent(studentId, studentFeedback);
    }

    @GetMapping("/student/studentFeedback/{studentFeedbackId}")
    public StudentFeedback getStudentFeedbackByStudentFeedbackId(@PathVariable int studentFeedbackId) {
    	if(!studentFeedbackRepository.existsById(studentFeedbackId)) {
    		throw new EduflexDataNotFoundException("Can't find studentFeedback with studentFeedbackId: "+studentFeedbackId+", please insert first");
    	}
        return studentFeedbackService.getStudentFeedbackByStudentFeedbackId(studentFeedbackId);
    }

    @GetMapping("/student/{studentId}/studentFeedbacks")
    public List<StudentFeedback> getStudentFeedbacksByStudentId(@PathVariable int studentId) {
    	if(!studentFeedbackRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't find studentFeedback with studentId: "+studentId+", please insert first");
    	}
        return studentFeedbackService.getStudentFeedbacksByStudentId(studentId);
    }

    @GetMapping("/studentFeedbacks")
    public List<StudentFeedback> getAllStudentFeedbacks() {
    	if(studentFeedbackRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("StudentFeedback Not Found, Add studentFeedbacks first");
		}
        return studentFeedbackService.getAllStudentFeedbacks();
    }

    @DeleteMapping("/student/{studentId}/studentFeedback/{studentFeedbackId}")
    public void deleteStudentFeedbackByStudentId(@PathVariable int studentId, @PathVariable int studentFeedbackId) {
    	if(!studentFeedbackRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't delete studentFeedback, studentId: "+studentId+", not have StudentFeedback in database");
    	}
        studentFeedbackService.deleteStudentFeedbackByStudentId(studentId, studentFeedbackId);
    }

    @DeleteMapping("/student/studentFeedback/{studentFeedbackId}")
    public void deleteStudentFeedbackByStudentFeedbackId( @PathVariable int studentFeedbackId) {
    	if(!studentFeedbackRepository.existsById(studentFeedbackId)) {
    		throw new EduflexDataNotFoundException("Can't delete studentFeedback, studentFeedbackId: "+studentFeedbackId+", not persent in database");
    	}
        studentFeedbackService.deleteStudentFeedbackByStudentFeedbackId(studentFeedbackId);
    }
}
