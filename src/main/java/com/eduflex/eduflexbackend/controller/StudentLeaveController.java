package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.StudentLeave;
import com.eduflex.eduflexbackend.repository.StudentLeaveRepository;
import com.eduflex.eduflexbackend.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentLeaveController {

    @Autowired
    StudentLeaveService studentLeaveService;
    
    @Autowired
    StudentLeaveRepository studentLeaveRepository;

    @GetMapping("/student/{studentId}/studentLeaves")
    public List<StudentLeave> getStudentLeavesByStudentId(@PathVariable int studentId) {
    	if(studentLeaveRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("StudentLeave Not Found with studentId "+studentId+", Add studentLeave first");
		}
        return studentLeaveService.getStudentLeavesByStudentId(studentId);
    }

    @GetMapping("/student/studentLeave/{studentLeaveId}")
    public StudentLeave getStudentLeaveByStudentLeaveId(@PathVariable int studentLeaveId) {
    	if(!studentLeaveRepository.existsById(studentLeaveId)) {
    		throw new EduflexDataNotFoundException("Can't find studentLeave with studentLeaveId: "+studentLeaveId+", please insert first");
    	}
        return studentLeaveService.getStudentLeaveByStudentLeaveId(studentLeaveId);
    }

    @PutMapping("/student/{studentId}/studentLeave")
    public StudentLeave addStudentLeaveToStudent(@RequestBody StudentLeave studentLeave, @PathVariable int studentId) {
    	if(!studentLeaveRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't add studentLeave to studentId: "+studentId+", because it not persent in database");
    	}
        return studentLeaveService.addStudentLeaveToStudent(studentId, studentLeave);
    }

    @DeleteMapping("/student/studentLeave/{studentLeaveId}")
    public void deleteStudentLeaveByStudentLeaveId(@PathVariable int studentLeaveId) {
    	if(!studentLeaveRepository.existsById(studentLeaveId)) {
    		throw new EduflexDataNotFoundException("Can't delete studentLeave, studentLeaveId: "+studentLeaveId+" not persent in database");
    	}
        studentLeaveService.deleteStudentLeaveByStudentLeaveId(studentLeaveId);
    }

    @DeleteMapping("/student/{studentId}/studentLeave/{studentLeaveId}")
    public void deleteStudentLeave(@PathVariable int studentId, @PathVariable int studentLeaveId) {
    	if(!studentLeaveRepository.existsById(studentId)) {
    		throw new EduflexDataNotFoundException("Can't delete studentLeave, studentId: "+studentId+", not have StudentLeave in database");
    	}
        studentLeaveService.deleteStudentLeaveByStudentId(studentId, studentLeaveId);
    }

    @GetMapping("/studentLeaves")
    public List<StudentLeave> getAllStudentLeaves() {
    	if(studentLeaveRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("StudentLeave Not Found, Add studentLeave first");
		}
        return studentLeaveService.getAllStudentLeaves();
    }
}
