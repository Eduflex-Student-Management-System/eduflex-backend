package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentLeave;
import com.eduflex.eduflexbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students/{classYearId}")
    public List<Student> getAllStudentsByClassYearId(@PathVariable int classYearId){
        return studentService.getAllStudentsByClassYearId(classYearId);
    }
}
