package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.StudentLeave;
import com.eduflex.eduflexbackend.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentLeaveController {

    @Autowired
    StudentLeaveService studentLeaveService;

    @GetMapping("student/{studentId}/studentLeaves")
    public List<StudentLeave> getStudentLeavesByStudentId(@PathVariable int studentId) {
        return studentLeaveService.getStudentLeavesByStudentId(studentId);
    }

    @GetMapping("student/{studentId}/studentLeave/{studentLeaveId}")
    public StudentLeave getStudentLeaveByStudentLeaveId(@PathVariable int studentId, @PathVariable int studentLeaveId) {
        return studentLeaveService.getStudentLeaveByStudentLeaveId(studentId, studentLeaveId);
    }

    @PutMapping("student/{studentId}/studentLeave")
    public StudentLeave addStudentLeaveToStudent(@RequestBody StudentLeave studentLeave, @PathVariable int studentId) {
        return studentLeaveService.addStudentLeaveToStudent(studentId, studentLeave);
    }

    @DeleteMapping("student/{studentId}/studentLeave/{studentLeaveId}")
    public void deleteStudentLeave(@PathVariable int studentId, @PathVariable int studentLeaveId) {
        studentLeaveService.deleteStudentLeave(studentId, studentLeaveId);
    }
}
